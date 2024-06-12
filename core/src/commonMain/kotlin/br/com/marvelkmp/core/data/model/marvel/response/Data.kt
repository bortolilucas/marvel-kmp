package br.com.marvelkmp.core.data.model.marvel.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data<T>(
    @SerialName("count")
    val count: Int,
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("results")
    val results: List<T>,
    @SerialName("total")
    val total: Int
)