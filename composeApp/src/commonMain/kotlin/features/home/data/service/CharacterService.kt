package features.home.data.service

import core.data.response.superhero.CharacterDto

interface CharacterService {
    suspend fun getCharacters(): List<CharacterDto>
}