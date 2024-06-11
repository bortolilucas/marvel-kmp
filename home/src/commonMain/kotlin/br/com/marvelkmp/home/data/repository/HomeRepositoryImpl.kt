package br.com.marvelkmp.home.data.repository

import br.com.marvelkmp.core.domain.mapper.toDomain
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import br.com.marvelkmp.home.data.service.HomeService
import br.com.marvelkmp.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val characterService: HomeService,
) : HomeRepository {
    override suspend fun getMarvelCharacters(): List<Character> {
        val characters = characterService.getCharacters()
        return characters
            .filter { it.biography.publisher == CharacterPublisher.Marvel.name }
            .map { it.toDomain() }
    }
}