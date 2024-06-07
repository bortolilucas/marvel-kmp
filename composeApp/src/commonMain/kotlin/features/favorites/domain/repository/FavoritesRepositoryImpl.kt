package features.favorites.domain.repository

import core.domain.model.Character
import database.Database
import features.favorites.data.repository.FavoritesRepository
import features.favorites.domain.mapper.toCharacter

class FavoritesRepositoryImpl(
    private val database: Database
) : FavoritesRepository {
    override suspend fun getFavorites(): List<Character> {
        val response = database.databaseQueries.getCharacters().executeAsList()
        return response.toCharacter()
    }

    override suspend fun addFavorite(favoriteCharacter: Character) {
        database.databaseQueries.addCharacter(
            id = favoriteCharacter.id.toLong(),
            heroName = favoriteCharacter.heroName,
            realName = favoriteCharacter.realName,
            imagePath = favoriteCharacter.images.sm,
            race = favoriteCharacter.race.name,
            height = favoriteCharacter.height,
            weight = favoriteCharacter.weight,
            gender = favoriteCharacter.gender,
            alignment = favoriteCharacter.alignment.name,
            publisher = favoriteCharacter.alignment.name
        )
    }
}