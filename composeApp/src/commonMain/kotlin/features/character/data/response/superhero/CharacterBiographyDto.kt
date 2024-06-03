package features.character.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterBiographyDto(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String?
)