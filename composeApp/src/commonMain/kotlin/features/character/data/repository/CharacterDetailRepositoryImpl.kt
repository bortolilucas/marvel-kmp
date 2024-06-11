package features.character.data.repository

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.database.Database
import features.character.data.model.CharacterComic
import features.character.data.model.MarvelApiCharacterDetails
import features.character.data.service.CharacterDetailsService
import features.character.domain.mapper.toCharacterComic
import features.character.domain.mapper.toMarvelApiCharacterDetails
import features.character.domain.repository.CharacterDetailRepository

class CharacterDetailRepositoryImpl(
    private val characterDetailsService: CharacterDetailsService,
    private val database: Database
) : CharacterDetailRepository {
    override suspend fun getCharacterDetails(characterName: String): MarvelApiCharacterDetails {
        val response = characterDetailsService.getCharacterDetails(characterName)
        return response.toMarvelApiCharacterDetails()
    }

    override suspend fun getCharacterComics(characterId: Int): List<CharacterComic> {
        val response = characterDetailsService.getCharacterComics(characterId)
        return response.toCharacterComic()
    }

    override suspend fun addFavorite(favoriteCharacter: Character) {
        database.databaseQueries.addCharacter(
            id = favoriteCharacter.id.toLong(),
            heroName = favoriteCharacter.heroName,
            realName = favoriteCharacter.realName,
            imagePath = favoriteCharacter.images.sm,
            race = favoriteCharacter.race?.name,
            height = favoriteCharacter.height,
            weight = favoriteCharacter.weight,
            gender = favoriteCharacter.gender,
        )

        database.databaseQueries.addCharacterStats(
            characterId = favoriteCharacter.id.toLong(),
            intelligence = favoriteCharacter.powerStats?.intelligence?.toLong() ?: 0,
            strength = favoriteCharacter.powerStats?.strength?.toLong() ?: 0,
            speed = favoriteCharacter.powerStats?.speed?.toLong() ?: 0,
            durability = favoriteCharacter.powerStats?.durability?.toLong() ?: 0,
            power = favoriteCharacter.powerStats?.power?.toLong() ?: 0,
            combat = favoriteCharacter.powerStats?.combat?.toLong() ?: 0,
        )
    }

    override suspend fun verifyIfFavorite(characterId: Int): Boolean {
        val response =
            database.databaseQueries.getCharacterById(characterId.toLong()).executeAsOneOrNull()
                ?: return false

        return response.toInt() > 0
    }

    override suspend fun removeFavorite(characterId: Int) {
        database.databaseQueries.removeCharacter(characterId.toLong())
    }
}