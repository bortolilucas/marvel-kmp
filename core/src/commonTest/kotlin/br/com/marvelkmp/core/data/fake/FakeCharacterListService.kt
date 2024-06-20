package br.com.marvelkmp.core.data.fake

import br.com.marvelkmp.core.data.model.superhero.CharacterDto
import br.com.marvelkmp.core.data.service.CharacterListService

class FakeCharacterListService : CharacterListService {
    private val characters = mutableListOf<CharacterDto>()

    fun addCharacters(newCharacters: List<CharacterDto>) {
        characters.addAll(newCharacters)
    }

    override suspend fun getCharacters(): List<CharacterDto> {
        return characters
    }
}