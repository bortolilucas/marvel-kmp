package br.com.marvelkmp.core.domain.usecase

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.repository.CharacterDetailRepository

class AddFavoriteUseCase(
    private val repository: CharacterDetailRepository
) {
    suspend operator fun invoke(favoriteCharacter: Character): Result<Unit> = runCatching {
        repository.addFavorite(favoriteCharacter)
    }
}
