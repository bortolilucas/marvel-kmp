package br.com.marvelkmp.core.domain.mapper

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterAlignment
import br.com.marvelkmp.core.domain.model.CharacterRaceType
import br.com.marvelkmp.core.presentation.model.CharacterFilter

fun List<Character>.filterBy(filterType: CharacterFilter): List<Character> = filter {
    when (filterType) {
        CharacterFilter.HERO -> it.alignment == CharacterAlignment.HERO
        CharacterFilter.VILLAIN -> it.alignment == CharacterAlignment.VILLAIN
        CharacterFilter.ANTIHERO -> it.alignment == CharacterAlignment.ANTIHERO
        CharacterFilter.HUMAN -> it.race?.type == CharacterRaceType.HUMAN
        CharacterFilter.ALIEN -> it.race?.type == CharacterRaceType.ALIEN
    }
}