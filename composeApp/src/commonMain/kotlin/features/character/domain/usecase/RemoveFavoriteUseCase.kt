package features.character.domain.usecase

import features.character.domain.repository.CharacterDetailRepository

class RemoveFavoriteUseCase (
    private val repository: CharacterDetailRepository
) {
    suspend operator fun invoke(characterId: Int): Result<Unit> = runCatching {
        repository.removeFavorite(characterId)
    }
}