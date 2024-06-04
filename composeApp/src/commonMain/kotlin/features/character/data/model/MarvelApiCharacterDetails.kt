package features.character.data.model

import features.character.data.model.response.Comics

data class MarvelApiCharacterDetails(
    val comics: Comics,
    val biography: String,
    val id: Int,
)