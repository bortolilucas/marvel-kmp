package br.com.marvelkmp.core.domain.repository

import br.com.marvelkmp.core.data.model.marvel.CharacterComic
import br.com.marvelkmp.core.data.model.marvel.MarvelApiCharacterDetails
import br.com.marvelkmp.core.domain.model.Character

interface CharacterDetailRepository {
    suspend fun getCharacterDetails(characterName: String): MarvelApiCharacterDetails

    suspend fun getCharacterComics(characterId: Int): List<CharacterComic>

    suspend fun addFavorite(favoriteCharacter: Character)

    suspend fun verifyIfFavorite(characterId: Int): Boolean

    suspend fun removeFavorite(characterId: Int)
}