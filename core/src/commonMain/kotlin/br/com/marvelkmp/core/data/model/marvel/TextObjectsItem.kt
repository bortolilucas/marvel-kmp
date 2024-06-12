package br.com.marvelkmp.core.data.model.marvel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TextObjectsItem(
    @SerialName("language")
    val language: String?,
    @SerialName("text")
    val text: String?,
    @SerialName("type")
    val type: String?
)