package features.character.domain.repository

import features.character.domain.model.Character

interface CharacterRepository {
    suspend fun getMarvelCharacters(): List<Character>
}