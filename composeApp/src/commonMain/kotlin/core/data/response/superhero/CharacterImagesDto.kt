package core.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterImagesDto(
    val lg: String,
    val md: String,
    val sm: String,
    val xs: String
)