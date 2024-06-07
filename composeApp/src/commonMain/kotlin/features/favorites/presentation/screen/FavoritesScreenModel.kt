package features.favorites.presentation.screen

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.presentation.model.ScreenState
import features.favorites.domain.usecase.AddFavoriteUseCase
import features.favorites.domain.usecase.GetFavoritesUseCase
import features.favorites.presentation.model.FavoritesState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesScreenModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase
) : StateScreenModel<FavoritesState>(FavoritesState()) {

    init {
        getFavorites()
    }

    fun getFavorites() = screenModelScope.launch {
        if (mutableState.value.state !== ScreenState.Loading)
            mutableState.update { it.copy(state = ScreenState.Default) }

        val result = getFavoritesUseCase()

        result.onSuccess { favorites ->
            mutableState.update { it.copy(state = ScreenState.Default, favorites = favorites) }
        }.onFailure {
            mutableState.update { it.copy(state = ScreenState.Error) }
        }

    }
}