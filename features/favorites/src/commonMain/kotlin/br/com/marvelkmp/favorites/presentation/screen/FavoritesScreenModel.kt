package br.com.marvelkmp.favorites.presentation.screen

import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.favorites.domain.usecase.GetFavoritesUseCase
import br.com.marvelkmp.favorites.presentation.model.FavoritesState
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesScreenModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
) : StateScreenModel<FavoritesState>(FavoritesState()) {
    fun onEvent(event: FavoritesEvent) {
        when (event) {
            FavoritesEvent.OnLaunch -> getFavorites()
            FavoritesEvent.OnRetry -> getFavorites()
        }
    }

    private fun getFavorites() = screenModelScope.launch {
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