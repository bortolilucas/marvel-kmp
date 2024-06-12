package br.com.marvelkmp.core.data.model.marvel

import br.com.marvelkmp.core.data.model.superhero.CharacterPowerStatsDto

data class CharacterDetails(
    val id: Int,
    val backgroundImage: String,
    val realName: String,
    val name: String,
    val race: String,
    val weight: String,
    val height: String,
    val gender: String,
    val biography: String? = null,
    val stats: CharacterPowerStatsDto? = null,
    val comics: List<CharacterComic>? = emptyList()
)