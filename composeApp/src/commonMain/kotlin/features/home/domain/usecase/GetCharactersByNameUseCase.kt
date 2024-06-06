package features.home.domain.usecase

import androidx.compose.ui.text.toLowerCase
import core.domain.model.Character
import features.home.domain.repository.CharacterRepository

class GetCharactersByNameUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(value: String): Result<List<Character>> =
        runCatching {
            val characters = characterRepository.getMarvelCharacters()

            val valueOnLower = value.lowercase()

            characters.filter {
                it.heroName.lowercase().contains(valueOnLower) || it.realName.lowercase()
                    .contains(valueOnLower)
            }
        }
}
