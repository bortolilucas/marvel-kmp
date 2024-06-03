package features.character.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterWorkDto(
    val base: String,
    val occupation: String
)