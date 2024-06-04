package core.data.response.superhero

import kotlinx.serialization.Serializable

@Serializable
data class CharacterConnectionsDto(
    val groupAffiliation: String,
    val relatives: String
)