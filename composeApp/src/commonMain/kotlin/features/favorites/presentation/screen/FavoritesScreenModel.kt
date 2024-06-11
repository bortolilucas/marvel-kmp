package features.favorites.presentation.screen

import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.logging.util.Log
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import features.favorites.domain.usecase.GetFavoritesUseCase
import features.favorites.presentation.model.FavoritesState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesScreenModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
) : StateScreenModel<FavoritesState>(FavoritesState()) {
    fun getFavorites() = screenModelScope.launch {
        if (mutableState.value.state !== ScreenState.Loading)
            mutableState.update { it.copy(state = ScreenState.Default) }

        val result = getFavoritesUseCase()

        result.onSuccess { favorites ->
            mutableState.update { it.copy(state = ScreenState.Default, favorites = favorites) }
        }.onFailure {
            Log.e("Error on get favorites", it)
            mutableState.update { it.copy(state = ScreenState.Error) }
        }

    }
}