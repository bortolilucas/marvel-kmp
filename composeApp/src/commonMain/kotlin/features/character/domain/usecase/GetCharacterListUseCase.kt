package features.character.domain.usecase

import br.com.marvelkmp.core.domain.mapper.filterBy
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import features.home.domain.repository.CharacterRepository

class GetCharacterListUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(type: CharacterFilter? = null): Result<List<Character>> =
        runCatching {
            val characters = characterRepository.getMarvelCharacters()

            type?.let { characters.filterBy(type) } ?: characters
        }
}