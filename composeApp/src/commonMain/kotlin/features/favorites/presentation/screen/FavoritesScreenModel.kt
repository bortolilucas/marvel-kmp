package features.favorites.presentation.screen

import cafe.adriel.voyager.core.model.StateScreenModel
import features.favorites.presentation.model.FavoritesState

class FavoritesScreenModel() : StateScreenModel<FavoritesState>(FavoritesState()) {
    fun getFavorites() {}
}