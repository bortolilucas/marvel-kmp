package features.character.domain.usecase

import features.character.domain.repository.CharacterDetailRepository

class VerifyIsFavoriteUseCase(
    private val repository: CharacterDetailRepository
) {
    suspend operator fun invoke(characterId: Int): Result<Boolean> = runCatching {
        repository.verifyIfFavorite(characterId)
    }
}