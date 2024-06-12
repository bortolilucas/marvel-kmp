package br.com.marvelkmp.core.data.model.marvel.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarvelApiResponse<T>(
    @SerialName("attributionHTML")
    val attributionHTML: String,
    @SerialName("attributionText")
    val attributionText: String,
    @SerialName("code")
    val code: Int,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("data")
    val data: Data<T>,
    @SerialName("etag")
    val etag: String,
    @SerialName("status")
    val status: String
)