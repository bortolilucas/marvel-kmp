package features.favorites.data.repository

import core.domain.model.Character

interface FavoritesRepository {
    suspend fun getFavorites(): List<Character>

    suspend fun addFavorite(favoriteCharacter: Character)
}