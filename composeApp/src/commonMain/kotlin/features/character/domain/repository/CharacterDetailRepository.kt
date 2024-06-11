package features.character.domain.repository

import br.com.marvelkmp.core.domain.model.Character
import features.character.data.model.CharacterComic
import features.character.data.model.MarvelApiCharacterDetails

interface CharacterDetailRepository {
    suspend fun getCharacterDetails(characterName: String): MarvelApiCharacterDetails

    suspend fun getCharacterComics(characterId: Int): List<CharacterComic>

    suspend fun addFavorite(favoriteCharacter: Character)

    suspend fun verifyIfFavorite(characterId: Int): Boolean

    suspend fun removeFavorite(characterId: Int)
}