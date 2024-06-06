package features.home.presentation.screens.home

import core.domain.model.Character
import core.presentation.model.ScreenState
import features.home.domain.model.CharacterSection

data class HomeState(
    val state: ScreenState = ScreenState.Loading,
    val sections: List<CharacterSection> = emptyList(),
    val showSearchInput: Boolean = false,
    val searchResults: List<Character> = emptyList(),
    val hasNotFoundResults: Boolean = false
)