package features.character.data.service

import features.character.data.response.superhero.CharacterDto

interface CharacterService {
    suspend fun getCharacters(): List<CharacterDto>
}