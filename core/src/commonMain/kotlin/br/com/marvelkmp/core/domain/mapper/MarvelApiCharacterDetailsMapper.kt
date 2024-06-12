package br.com.marvelkmp.core.domain.mapper

import br.com.marvelkmp.core.data.model.marvel.MarvelApiCharacterDetails
import br.com.marvelkmp.core.data.model.marvel.response.CharacterDetailsResult
import br.com.marvelkmp.core.data.model.marvel.response.MarvelApiResponse

fun MarvelApiResponse<CharacterDetailsResult>.toMarvelApiCharacterDetails() =
    MarvelApiCharacterDetails(
        id = data.results.first().id,
        biography = data.results.first().description,
        comics = data.results.first().comics,
    )