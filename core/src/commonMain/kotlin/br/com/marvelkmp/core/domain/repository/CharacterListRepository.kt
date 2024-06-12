package br.com.marvelkmp.core.domain.repository

import br.com.marvelkmp.core.domain.model.Character

interface CharacterListRepository {
    suspend fun getMarvelCharacters(): List<Character>
}