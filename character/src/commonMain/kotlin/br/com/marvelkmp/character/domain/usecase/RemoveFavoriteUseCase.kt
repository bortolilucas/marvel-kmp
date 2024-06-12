package br.com.marvelkmp.character.domain.usecase

import br.com.marvelkmp.core.domain.repository.CharacterDetailRepository

class RemoveFavoriteUseCase(
    private val repository: CharacterDetailRepository
) {
    suspend operator fun invoke(characterId: Int): Result<Unit> = runCatching {
        repository.removeFavorite(characterId)
    }
}