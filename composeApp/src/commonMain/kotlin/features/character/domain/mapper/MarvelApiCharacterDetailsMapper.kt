package features.character.domain.mapper

import features.character.data.model.MarvelApiCharacterDetails
import features.character.data.model.response.CharacterDetailsResult
import features.character.data.model.response.MarvelApiResponse

fun MarvelApiResponse<CharacterDetailsResult>.toMarvelApiCharacterDetails() =
    MarvelApiCharacterDetails(
        id = data.results.first().id,
        biography = data.results.first().description,
        comics = data.results.first().comics,
    )