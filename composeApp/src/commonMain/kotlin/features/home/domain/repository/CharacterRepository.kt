package features.home.domain.repository

import br.com.marvelkmp.core.domain.model.Character

interface CharacterRepository {
    suspend fun getMarvelCharacters(): List<Character>
}