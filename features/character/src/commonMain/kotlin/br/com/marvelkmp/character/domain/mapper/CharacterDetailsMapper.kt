package br.com.marvelkmp.character.domain.mapper

import br.com.marvelkmp.core.data.model.marvel.CharacterComic
import br.com.marvelkmp.core.data.model.marvel.CharacterDetails
import br.com.marvelkmp.core.domain.model.Character

fun Character.toCharacterDetails(bio: String, comics: List<CharacterComic>): CharacterDetails =
    CharacterDetails(
        id = id,
        backgroundImage = images.lg,
        realName = realName,
        name = heroName,
        biography = bio,
        height = height.orEmpty(),
        weight = weight.orEmpty(),
        race = race?.name.orEmpty(),
        stats = powerStats,
        gender = gender,
        comics = comics
    )