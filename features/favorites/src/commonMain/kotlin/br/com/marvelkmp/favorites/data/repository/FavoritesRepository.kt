package br.com.marvelkmp.favorites.data.repository

import br.com.marvelkmp.core.domain.model.Character

interface FavoritesRepository {
    suspend fun getFavorites(): List<Character>
}