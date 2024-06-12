package br.com.marvelkmp.core.data.model.marvel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
)