package features.home.presentation.screens.home

import core.presentation.model.ScreenState
import features.home.domain.model.CharacterSection

data class HomeState(
    val state: ScreenState = ScreenState.Loading,
    val sections: List<CharacterSection> = emptyList()
)