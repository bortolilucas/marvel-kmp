package features.home.data.repository

import br.com.marvelkmp.core.domain.mapper.toDomain
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import features.home.data.service.CharacterService
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