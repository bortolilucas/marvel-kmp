package br.com.marvelkmp.character.domain.usecase

import br.com.marvelkmp.core.domain.mapper.filterBy
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.repository.CharacterListRepository
import br.com.marvelkmp.core.presentation.model.CharacterFilter

class GetCharacterListUseCase(
    private val characterRepository: CharacterListRepository
) {
    suspend operator fun invoke(type: CharacterFilter? = null): Result<List<Character>> =
        runCatching {
            val characters = characterRepository.getMarvelCharacters()

            type?.let { characters.filterBy(type) } ?: characters
        }
}