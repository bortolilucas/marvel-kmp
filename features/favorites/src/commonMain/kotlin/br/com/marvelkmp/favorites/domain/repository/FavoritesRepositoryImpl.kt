package br.com.marvelkmp.favorites.domain.repository

import app.cash.sqldelight.async.coroutines.awaitAsList
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.database.Database
import br.com.marvelkmp.favorites.data.repository.FavoritesRepository
import br.com.marvelkmp.favorites.domain.mapper.toCharacter

class FavoritesRepositoryImpl(
    private val database: Database
) : FavoritesRepository {
    override suspend fun getFavorites(): List<Character> {
        val response = database.getDatabaseQueries().getCharacters().awaitAsList()
        return response.toCharacter()
    }
}