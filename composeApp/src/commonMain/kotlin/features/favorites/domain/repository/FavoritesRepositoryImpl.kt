package features.favorites.domain.repository

import core.domain.model.Character
import features.favorites.data.repository.FavoritesRepository

class FavoritesRepositoryImpl: FavoritesRepository {
    override suspend fun getFavorites(): List<Character> {
        return emptyList()
    }
}