package br.com.marvelkmp.character.domain.mock

import br.com.marvelkmp.core.data.model.superhero.CharacterAppearanceDto
import br.com.marvelkmp.core.data.model.superhero.CharacterPowerStatsDto
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterAlignment
import br.com.marvelkmp.core.domain.model.CharacterImages
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import br.com.marvelkmp.core.domain.model.CharacterRace

val mockCharactersList = listOf(
    Character(
        id = 1,
        heroName = "A-Bomb",
        realName = "Richard Milhouse Jones",
        alignment = CharacterAlignment.parse("good"),
        images = CharacterImages(
            sm = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/1-a-bomb.jpg",
            lg = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/1-a-bomb.jpg"
        ),
        gender = "Male",
        race = CharacterRace.parse("Human"),
        publisher = CharacterPublisher.parse("Marvel Comics"),
        powerStats = CharacterPowerStatsDto(
            intelligence = 38,
            strength = 100,
            speed = 17,
            durability = 80,
            power = 24,
            combat = 64
        ),
        appearance = CharacterAppearanceDto(
            eyeColor = "Yellow",
            gender = "Male",
            hairColor = "No Hair",
            height = listOf("6'8", "203 cm"),
            race = "Human",
            weight = listOf("980 lb", "441 kg")
        ),
        weight = "441 kg",
        height = "203 cm"
    ),
    Character(
        id = 2,
        heroName = "Abe Sapien",
        realName = "Abraham Sapien",
        alignment = CharacterAlignment.parse("bad"),
        images = CharacterImages(
            sm = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/2-abe-sapien.jpg",
            lg = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/2-abe-sapien.jpg"
        ),
        gender = "Male",
        race = CharacterRace.parse("Icthyo Sapien"),
        publisher = CharacterPublisher.parse("Dark Horse Comics"),
        powerStats = CharacterPowerStatsDto(
            intelligence = 88,
            strength = 28,
            speed = 35,
            durability = 65,
            power = 100,
            combat = 85
        ),
        appearance = CharacterAppearanceDto(
            eyeColor = "Blue",
            gender = "Male",
            hairColor = "No Hair",
            height = listOf("6'3", "191 cm"),
            race = "Icthyo Sapien",
            weight = listOf("145 lb", "65 kg")
        ),
        weight = "65 kg",
        height = "191 cm"
    ),
    Character(
        id = 3,
        heroName = "Abin Sur",
        realName = "",
        alignment = CharacterAlignment.parse("good"),
        images = CharacterImages(
            sm = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/3-abin-sur.jpg",
            lg = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/3-abin-sur.jpg"
        ),
        gender = "Male",
        race = CharacterRace.parse("Ungaran"),
        publisher = CharacterPublisher.parse("DC Comics"),
        powerStats = CharacterPowerStatsDto(
            intelligence = 50,
            strength = 90,
            speed = 53,
            durability = 64,
            power = 99,
            combat = 65
        ),
        appearance = CharacterAppearanceDto(
            eyeColor = "Blue",
            gender = "Male",
            hairColor = "No Hair",
            height = listOf("6'1", "185 cm"),
            race = "Ungaran",
            weight = listOf("200 lb", "90 kg")
        ),
        weight = "90 kg",
        height = "185 cm"
    )
)
