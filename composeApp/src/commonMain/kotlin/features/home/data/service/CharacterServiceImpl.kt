package features.home.data.service

import core.data.response.superhero.CharacterDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharacterServiceImpl(
    private val superHeroApiClient: HttpClient
) : CharacterService {
    override suspend fun getCharacters(): List<CharacterDto> {
        val response = superHeroApiClient.get("/gh/akabab/superhero-api@0.3.0/api/all.json")

        return response.body()
    }
}