package br.com.marvelkmp.core.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterAppearanceDto(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String?,
    val weight: List<String>
)