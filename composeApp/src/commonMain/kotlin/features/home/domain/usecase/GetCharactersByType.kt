package features.home.domain.usecase

import core.domain.mapper.filterBy
import core.presentation.model.CharacterFilter
import features.home.domain.model.CharacterSection
import features.home.domain.repository.CharacterRepository

class GetCharactersByTypeUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(): Result<List<CharacterSection>> = runCatching {
        val characters = characterRepository.getMarvelCharacters().shuffled()

        CharacterFilter.entries.map { filterType ->
            CharacterSection(
                type = filterType,
                characters = characters.filterBy(filterType).slice(0..10),
            )
        }
    }
}