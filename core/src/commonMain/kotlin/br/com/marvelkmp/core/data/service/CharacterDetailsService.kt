package br.com.marvelkmp.core.data.service

import br.com.marvelkmp.core.data.model.marvel.CharacterComicsResult
import br.com.marvelkmp.core.data.model.marvel.response.CharacterDetailsResult
import br.com.marvelkmp.core.data.model.marvel.response.MarvelApiResponse

interface CharacterDetailsService {
    suspend fun getCharacterDetails(characterName: String): MarvelApiResponse<CharacterDetailsResult>

    suspend fun getCharacterComics(characterId: Int): MarvelApiResponse<CharacterComicsResult>
}