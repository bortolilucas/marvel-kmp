package br.com.marvelkmp.core.data.service

import br.com.marvelkmp.core.data.model.superhero.CharacterDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharacterListServiceImpl(
    private val superHeroApiClient: HttpClient
) : CharacterListService {
    override suspend fun getCharacters(): List<CharacterDto> {
        val response = superHeroApiClient.get("/gh/akabab/superhero-api@0.3.0/api/all.json")

        return response.body()
    }
}