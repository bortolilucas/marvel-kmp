package features.character.domain.mapper

import features.character.data.response.superhero.CharacterDto
import features.character.domain.model.Character
import features.character.domain.model.CharacterAlignment
import features.character.domain.model.CharacterImages
import features.character.domain.model.CharacterPublisher
import features.character.domain.model.CharacterRace

fun CharacterDto.toDomain(): Character = Character(
    id = id,
    heroName = name,
    realName = biography.fullName,
    alignment = CharacterAlignment.parse(biography.alignment),
    images = CharacterImages(
        sm = images.sm
    ),
    race = appearance.race?.let { CharacterRace.parse(it) },
    publisher = biography.publisher?.let { CharacterPublisher.parse(it) }
)