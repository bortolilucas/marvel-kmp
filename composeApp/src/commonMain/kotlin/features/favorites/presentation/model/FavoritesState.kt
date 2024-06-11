package features.favorites.presentation.model

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.model.ScreenState

data class FavoritesState(
    val state: ScreenState = ScreenState.Loading,
    val favorites: List<Character> = emptyList()
)