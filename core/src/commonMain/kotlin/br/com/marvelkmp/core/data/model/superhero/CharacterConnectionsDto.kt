package br.com.marvelkmp.core.data.model.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterConnectionsDto(
    val groupAffiliation: String,
    val relatives: String
)