package br.com.marvelkmp.home.domain.usecase

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.repository.CharacterListRepository

class GetCharactersByNameUseCase(
    private val repository: CharacterListRepository
) {
    suspend operator fun invoke(value: String): Result<List<Character>> =
        runCatching {
            val characters = repository.getMarvelCharacters()

            val valueOnLower = value.lowercase()

            characters.filter {
                it.heroName.lowercase().contains(valueOnLower) || it.realName.lowercase()
                    .contains(valueOnLower)
            }
        }
}
