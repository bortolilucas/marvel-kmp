package core.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Int,
    val appearance: CharacterAppearanceDto,
    val biography: CharacterBiographyDto,
    val connections: CharacterConnectionsDto,
    val images: CharacterImagesDto,
    val name: String,
    val powerstats: CharacterPowerStatsDto,
    val slug: String,
    val work: CharacterWorkDto
)