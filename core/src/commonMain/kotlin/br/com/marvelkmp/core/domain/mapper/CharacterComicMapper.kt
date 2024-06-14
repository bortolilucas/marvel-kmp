package br.com.marvelkmp.core.domain.mapper

import br.com.marvelkmp.core.data.model.marvel.CharacterComic
import br.com.marvelkmp.core.data.model.marvel.CharacterComicsResult
import br.com.marvelkmp.core.data.model.marvel.response.MarvelApiResponse
import br.com.marvelkmp.core.domain.utils.toHttpsUrl

fun MarvelApiResponse<CharacterComicsResult>.toCharacterComic() =
    data.results.map {
        CharacterComic(
            id = it.id,
            title = it.title,
            cover = "${it.thumbnail?.path}.${it.thumbnail?.extension}".toHttpsUrl()
        )
    }