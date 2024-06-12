package br.com.marvelkmp.core.domain.mapper

import br.com.marvelkmp.core.data.model.superhero.CharacterDto
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterAlignment
import br.com.marvelkmp.core.domain.model.CharacterImages
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import br.com.marvelkmp.core.domain.model.CharacterRace

fun CharacterDto.toDomain(): Character = Character(
    id = id,
    heroName = name,
    realName = biography.fullName,
    alignment = CharacterAlignment.parse(biography.alignment),
    images = CharacterImages(
        sm = images.sm,
        lg = images.lg
    ),
    race = appearance.race?.let { CharacterRace.parse(it) },
    publisher = biography.publisher?.let { CharacterPublisher.parse(it) },
    weight = appearance.weight.last(),
    height = appearance.height.last(),
    gender = appearance.gender,
    powerStats = powerstats
)