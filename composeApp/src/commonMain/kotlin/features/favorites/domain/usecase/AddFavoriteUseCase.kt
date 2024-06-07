package features.favorites.domain.usecase

import core.domain.model.Character
import features.favorites.data.repository.FavoritesRepository

class AddFavoriteUseCase(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(favoriteCharacter: Character): Result<Unit> = runCatching {
        repository.addFavorite(favoriteCharacter)
    }
}