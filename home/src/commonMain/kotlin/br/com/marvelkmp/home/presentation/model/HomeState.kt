package br.com.marvelkmp.home.presentation.model

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.home.domain.model.CharacterSection

data class HomeState(
    val state: ScreenState = ScreenState.Loading,
    val sections: List<CharacterSection> = emptyList(),
    val showSearchInput: Boolean = false,
    val searchResults: List<Character> = emptyList(),
    val hasNotFoundResults: Boolean = false
)