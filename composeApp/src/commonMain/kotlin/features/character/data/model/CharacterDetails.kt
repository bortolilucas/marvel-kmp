package features.character.data.model

import br.com.marvelkmp.core.data.response.superhero.CharacterPowerStatsDto

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