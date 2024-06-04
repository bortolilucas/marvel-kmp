package features.character.data.service

import features.character.data.model.response.CharacterDetailResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharacterDetailsServiceImpl(
    private val marvelApiClient: HttpClient
) : CharacterDetailsService {
    override suspend fun getCharacterDetails(characterName: String): CharacterDetailResponse {
        val response = marvelApiClient.get("characters?name=$characterName&limit=1")
        return response.body()
    }
}