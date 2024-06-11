package br.com.marvelkmp.core.domain.model

import br.com.marvelkmp.core.data.response.superhero.CharacterAppearanceDto
import br.com.marvelkmp.core.data.response.superhero.CharacterPowerStatsDto

data class Character(
    val id: Int,
    val heroName: String,
    val realName: String,
    val alignment: CharacterAlignment,
    val images: CharacterImages,
    val gender: String,
    val race: CharacterRace? = null,
    val publisher: CharacterPublisher? = null,
    val powerStats: CharacterPowerStatsDto? = null,
    val appearance: CharacterAppearanceDto? = null,
    val weight: String? = null,
    val height: String? = null
)
