package br.com.marvelkmp.favorites.domain.mapper

import br.com.marvelkmp.app.GetCharacters
import br.com.marvelkmp.core.data.model.superhero.CharacterAppearanceDto
import br.com.marvelkmp.core.data.model.superhero.CharacterPowerStatsDto
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterAlignment
import br.com.marvelkmp.core.domain.model.CharacterImages
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import br.com.marvelkmp.core.domain.model.CharacterRace

fun List<GetCharacters>.toCharacter(): List<Character> = map {
    Character(
        id = it.id.toInt(),
        heroName = it.heroName,
        realName = it.realName,
        publisher = CharacterPublisher.parse(""),
        images = CharacterImages(lg = it.imagePath, sm = it.imagePath),
        alignment = CharacterAlignment.parse("neutral"),
        race = CharacterRace.parse(it.race.orEmpty()),
        gender = it.gender,
        powerStats = CharacterPowerStatsDto(
            intelligence = it.intelligence?.toInt() ?: 0,
            strength = it.strength?.toInt() ?: 0,
            speed = it.speed?.toInt() ?: 0,
            durability = it.durability?.toInt() ?: 0,
            power = it.power?.toInt() ?: 0,
            combat = it.combat?.toInt() ?: 0
        ),
        appearance = CharacterAppearanceDto(
            gender = it.gender,
            race = it.race,
            height = listOf(it.height.orEmpty()),
            weight = listOf(it.weight.orEmpty()),
            hairColor = "",
            eyeColor = ""
        ),
        height = it.height,
        weight = it.weight
    )
}