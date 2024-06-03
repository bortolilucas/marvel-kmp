package core.domain.mapper

import core.data.response.superhero.CharacterDto
import core.domain.model.Character
import core.domain.model.CharacterAlignment
import core.domain.model.CharacterImages
import core.domain.model.CharacterPublisher
import core.domain.model.CharacterRace

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