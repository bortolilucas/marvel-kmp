package features.character.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
)