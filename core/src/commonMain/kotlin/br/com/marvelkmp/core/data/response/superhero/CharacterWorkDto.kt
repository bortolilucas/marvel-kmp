package br.com.marvelkmp.core.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterWorkDto(
    val base: String,
    val occupation: String
)