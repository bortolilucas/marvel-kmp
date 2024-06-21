package br.com.marvelkmp.favorites.domain.repository

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.database.Database
import br.com.marvelkmp.favorites.data.repository.FavoritesRepository
import br.com.marvelkmp.favorites.domain.mapper.toCharacter

class FavoritesRepositoryImpl(
    private val database: Database
) : FavoritesRepository {
    override suspend fun getFavorites(): List<Character> {
        val response = database.databaseQueries.getCharacters().executeAsList()
        return response.toCharacter()
    }
}