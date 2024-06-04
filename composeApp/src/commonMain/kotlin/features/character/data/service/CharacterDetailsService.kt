package features.character.data.service

import features.character.data.model.CharacterComicsResult
import features.character.data.model.response.CharacterDetailsResult
import features.character.data.model.response.MarvelApiResponse

interface CharacterDetailsService {
    suspend fun getCharacterDetails(characterName: String): MarvelApiResponse<CharacterDetailsResult>

    suspend fun getCharacterComics(characterId: Int): MarvelApiResponse<CharacterComicsResult>
}