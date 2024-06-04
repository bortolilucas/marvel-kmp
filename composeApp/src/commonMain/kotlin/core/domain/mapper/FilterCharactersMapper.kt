package core.domain.mapper

import core.domain.model.Character
import core.domain.model.CharacterAlignment
import core.domain.model.CharacterRaceType
import core.presentation.model.CharacterFilter

fun List<Character>.filterBy(filterType: CharacterFilter): List<Character> =
    when (filterType) {
        CharacterFilter.HERO -> filter { it.alignment == CharacterAlignment.HERO }
        CharacterFilter.VILLAIN -> filter { it.alignment == CharacterAlignment.VILLAIN }
        CharacterFilter.ANTIHERO -> filter { it.alignment == CharacterAlignment.ANTIHERO }
        CharacterFilter.HUMAN -> filter { it.race?.type == CharacterRaceType.HUMAN }
        CharacterFilter.ALIEN -> filter { it.race?.type == CharacterRaceType.ALIEN }
    }