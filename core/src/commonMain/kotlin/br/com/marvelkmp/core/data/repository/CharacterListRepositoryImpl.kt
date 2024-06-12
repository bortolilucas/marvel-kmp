package br.com.marvelkmp.core.data.repository

import br.com.marvelkmp.core.data.service.CharacterListService
import br.com.marvelkmp.core.domain.mapper.toDomain
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import br.com.marvelkmp.core.domain.repository.CharacterListRepository

class CharacterListRepositoryImpl(
    private val characterService: CharacterListService,
) : CharacterListRepository {
    override suspend fun getMarvelCharacters(): List<Character> {
        val characters = characterService.getCharacters()
        return characters
            .filter { it.biography.publisher == CharacterPublisher.Marvel.name }
            .map { it.toDomain() }
    }
}