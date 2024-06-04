package features.character.domain.mapper

import features.character.data.model.CharacterComic
import features.character.data.model.CharacterComicsResult
import features.character.data.model.response.MarvelApiResponse
import features.character.domain.utils.toHttpsUrl

fun MarvelApiResponse<CharacterComicsResult>.toCharacterComic() = data.results.map {
    CharacterComic(
        id = it.id!!,
        title = it.title!!,
        cover = "${it.thumbnail?.path}.${it.thumbnail?.extension}".toHttpsUrl()
    )
}