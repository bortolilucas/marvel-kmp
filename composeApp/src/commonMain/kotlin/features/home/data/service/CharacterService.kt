package features.home.data.service

import br.com.marvelkmp.core.data.response.superhero.CharacterDto

interface CharacterService {
    suspend fun getCharacters(): List<CharacterDto>
}