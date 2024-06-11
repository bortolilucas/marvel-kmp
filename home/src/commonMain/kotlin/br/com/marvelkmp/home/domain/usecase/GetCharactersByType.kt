package br.com.marvelkmp.home.domain.usecase

import br.com.marvelkmp.core.domain.mapper.filterBy
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.home.domain.model.CharacterSection
import br.com.marvelkmp.home.domain.repository.HomeRepository

class GetCharactersByTypeUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<CharacterSection>> = runCatching {
        val characters = repository.getMarvelCharacters().shuffled()

        CharacterFilter.entries.map { filterType ->
            CharacterSection(
                type = filterType,
                characters = characters.filterBy(filterType).slice(0..10),
            )
        }
    }
}