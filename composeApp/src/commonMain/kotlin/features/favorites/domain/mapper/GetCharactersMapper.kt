package features.favorites.domain.mapper

import br.com.marvelkmp.app.GetCharacters
import core.data.response.superhero.CharacterAppearanceDto
import core.data.response.superhero.CharacterPowerStatsDto
import core.domain.model.Character
import core.domain.model.CharacterAlignment
import core.domain.model.CharacterImages
import core.domain.model.CharacterPublisher
import core.domain.model.CharacterRace

fun List<GetCharacters>.toCharacter(): List<Character> = map {
    Character(
        id = it.id.toInt(),
        heroName = it.heroName,
        realName = it.realName,
        publisher = CharacterPublisher.parse(it.publisher),
        images = CharacterImages(sm = it.imagePath),
        alignment = CharacterAlignment.parse(it.alignment),
        race = CharacterRace.parse(it.race),
        gender = it.gender,
        powerStats = CharacterPowerStatsDto(
            intelligence = it.intelligence.toInt(),
            strength = it.strength.toInt(),
            speed = it.speed.toInt(),
            durability = it.durability.toInt(),
            power = it.power.toInt(),
            combat = it.combat.toInt()
        ),
        appearance = CharacterAppearanceDto(
            gender = it.gender,
            race = it.race,
            height = listOf(it.height) as List<String>,
            weight = listOf(it.weight) as List<String>,
            hairColor = "",
            eyeColor = ""
        ),
        height = it.height,
        weight = it.weight
    )
}