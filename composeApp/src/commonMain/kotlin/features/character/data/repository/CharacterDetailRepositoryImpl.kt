package features.character.data.repository

import features.character.data.model.CharacterComic
import features.character.data.model.MarvelApiCharacterDetails
import features.character.data.service.CharacterDetailsService
import features.character.domain.mapper.toCharacterComic
import features.character.domain.mapper.toMarvelApiCharacterDetails
import features.character.domain.repository.CharacterDetailRepository

class CharacterDetailRepositoryImpl(
    private val characterDetailsService: CharacterDetailsService
): CharacterDetailRepository {
    override suspend fun getCharacterDetails(characterName: String): MarvelApiCharacterDetails {
        val response = characterDetailsService.getCharacterDetails(characterName)
        return response.toMarvelApiCharacterDetails()
    }

    override suspend fun getCharacterComics(characterId: Int): List<CharacterComic> {
        val response = characterDetailsService.getCharacterComics(characterId)
        return response.toCharacterComic()
    }
}