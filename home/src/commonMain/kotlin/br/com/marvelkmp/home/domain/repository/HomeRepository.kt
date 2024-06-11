package br.com.marvelkmp.home.domain.repository

import br.com.marvelkmp.core.domain.model.Character

interface HomeRepository {
    suspend fun getMarvelCharacters(): List<Character>
}