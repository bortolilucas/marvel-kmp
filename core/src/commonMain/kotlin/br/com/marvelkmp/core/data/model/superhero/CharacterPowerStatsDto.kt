package br.com.marvelkmp.core.data.model.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterPowerStatsDto(
    val combat: Int,
    val durability: Int,
    val intelligence: Int,
    val power: Int,
    val speed: Int,
    val strength: Int
)