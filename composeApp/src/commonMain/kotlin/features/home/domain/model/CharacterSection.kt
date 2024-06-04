package features.home.domain.model

import core.domain.model.Character
import core.presentation.model.CharacterFilter

data class CharacterSection(
    val characters: List<Character>,
    val type: CharacterFilter,
)
