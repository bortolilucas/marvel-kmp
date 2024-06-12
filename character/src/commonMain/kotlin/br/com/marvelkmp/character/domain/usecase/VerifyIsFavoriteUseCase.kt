package br.com.marvelkmp.character.domain.usecase

import br.com.marvelkmp.core.domain.repository.CharacterDetailRepository

class VerifyIsFavoriteUseCase(
    private val repository: CharacterDetailRepository
) {
    suspend operator fun invoke(characterId: Int): Result<Boolean> = runCatching {
        repository.verifyIfFavorite(characterId)
    }
}