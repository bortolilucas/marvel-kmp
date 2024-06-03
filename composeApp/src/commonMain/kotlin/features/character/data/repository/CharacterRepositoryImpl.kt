package features.character.data.repository

import features.character.data.service.CharacterService
import features.character.domain.mapper.toDomain
import features.character.domain.model.Character
import features.character.domain.model.CharacterPublisher
import features.character.domain.repository.CharacterRepository

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