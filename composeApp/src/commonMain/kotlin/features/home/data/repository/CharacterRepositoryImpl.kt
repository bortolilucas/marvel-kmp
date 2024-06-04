package features.home.data.repository

import features.home.data.service.CharacterService
import core.domain.mapper.toDomain
import core.domain.model.Character
import core.domain.model.CharacterPublisher
import features.home.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterService: CharacterService,
) : CharacterRepository {
    override suspend fun getMarvelCharacters(): List<Character> {
        val characters = characterService.getCharacters()
        return characters
            .filter { it.biography.publisher == CharacterPublisher.Marvel.name }
            .map { it.toDomain() }
    }
}