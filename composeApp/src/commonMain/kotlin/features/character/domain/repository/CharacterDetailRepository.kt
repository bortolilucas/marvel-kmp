package features.character.domain.repository

import features.character.data.model.CharacterComic
import features.character.data.model.MarvelApiCharacterDetails

interface CharacterDetailRepository {
    suspend fun getCharacterDetails(characterName: String): MarvelApiCharacterDetails

    suspend fun getCharacterComics(characterId: Int): List<CharacterComic>
}