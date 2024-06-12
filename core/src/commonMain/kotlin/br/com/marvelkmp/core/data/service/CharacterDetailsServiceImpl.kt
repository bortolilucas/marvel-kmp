package br.com.marvelkmp.core.data.service

import br.com.marvelkmp.core.data.model.marvel.CharacterComicsResult
import br.com.marvelkmp.core.data.model.marvel.response.CharacterDetailsResult
import br.com.marvelkmp.core.data.model.marvel.response.MarvelApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharacterDetailsServiceImpl(
    private val marvelApiClient: HttpClient
) : CharacterDetailsService {
    override suspend fun getCharacterDetails(characterName: String): MarvelApiResponse<CharacterDetailsResult> {
        val response = marvelApiClient.get("characters?nameStartsWith=$characterName&limit=1")
        return response.body()
    }

    override suspend fun getCharacterComics(characterId: Int): MarvelApiResponse<CharacterComicsResult> {
        val response = marvelApiClient.get("characters/$characterId/comics?limit=5")
        return response.body()
    }
}