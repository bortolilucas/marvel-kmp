package features.home.domain.repository

import core.domain.model.Character

interface CharacterRepository {
    suspend fun getMarvelCharacters(): List<Character>
}