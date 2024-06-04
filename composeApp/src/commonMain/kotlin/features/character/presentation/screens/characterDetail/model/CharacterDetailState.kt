package features.character.presentation.screens.characterDetail.model

import core.domain.model.Character
import core.presentation.model.ScreenState
import features.character.data.model.CharacterDetails

data class CharacterDetailState(
    val state: ScreenState = ScreenState.Loading,
    val character: CharacterDetails? = null
)
