package br.com.marvelkmp.core.data.model.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterWorkDto(
    val base: String,
    val occupation: String
)