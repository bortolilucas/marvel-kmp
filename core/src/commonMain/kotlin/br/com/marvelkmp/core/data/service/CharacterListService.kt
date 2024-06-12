package br.com.marvelkmp.core.data.service

import br.com.marvelkmp.core.data.model.superhero.CharacterDto

interface CharacterListService {
    suspend fun getCharacters(): List<CharacterDto>
}