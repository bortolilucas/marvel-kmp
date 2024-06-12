package br.com.marvelkmp.core.data.model.marvel.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("name")
    val name: String,
    @SerialName("resourceURI")
    val resourceURI: String,
    @SerialName("type")
    val type: String? = null,
    @SerialName("role")
    val role: String? = null
)