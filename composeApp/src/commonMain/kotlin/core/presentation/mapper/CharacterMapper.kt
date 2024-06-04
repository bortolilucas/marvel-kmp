package core.presentation.mapper

import core.presentation.model.CharacterFilter

fun CharacterFilter.asString(): String = when (this) {
    CharacterFilter.HUMAN -> "Humans"
    CharacterFilter.HERO -> "Heroes"
    CharacterFilter.VILLAIN -> "Villains"
    CharacterFilter.ANTIHERO -> "Anti-Heroes"
    CharacterFilter.ALIEN -> "Aliens"
}
