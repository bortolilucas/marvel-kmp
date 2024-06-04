package features.character.data.service

import features.character.data.model.response.CharacterDetailResponse

interface CharacterDetailsService {
    suspend fun getCharacterDetails(characterName: String): CharacterDetailResponse
}