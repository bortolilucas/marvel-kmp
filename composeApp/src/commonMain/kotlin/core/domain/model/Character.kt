package core.domain.model

data class Character(
    val id: Int,
    val heroName: String,
    val realName: String,
    val alignment: CharacterAlignment,
    val images: CharacterImages,
    val race: CharacterRace?,
    val publisher: CharacterPublisher?,
)
