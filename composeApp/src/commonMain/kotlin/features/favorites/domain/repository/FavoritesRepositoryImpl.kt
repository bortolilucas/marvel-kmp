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
}