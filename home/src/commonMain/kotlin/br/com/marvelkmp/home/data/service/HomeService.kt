package br.com.marvelkmp.home.data.service

import br.com.marvelkmp.core.data.response.superhero.CharacterDto

interface HomeService {
    suspend fun getCharacters(): List<CharacterDto>
}