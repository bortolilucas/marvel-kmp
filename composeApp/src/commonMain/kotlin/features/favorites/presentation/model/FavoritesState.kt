package features.favorites.presentation.model

import core.domain.model.Character
import core.presentation.model.ScreenState

data class FavoritesState(
    val state: ScreenState = ScreenState.Loading,
    val favorites: List<Character> = emptyList()
)