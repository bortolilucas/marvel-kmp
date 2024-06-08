package features.favorites.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import core.presentation.composables.error.ErrorContainer
import core.presentation.composables.loading.Loading
import core.presentation.model.ScreenState
import features.character.presentation.screens.characterDetail.CharacterDetailScreen
import features.favorites.presentation.composables.Default

object FavoritesScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<FavoritesScreenModel>()
        val screenModelState by screenModel.state.collectAsState()
        val state = screenModelState.state

        val navigator = LocalNavigator.currentOrThrow

        fun onBack() {
            navigator.pop()
        }

        LaunchedEffect(key1 = Unit) {
            screenModel.getFavorites()
        }

        Column {
            when (state) {
                ScreenState.Default -> Default(
                    favorites = screenModelState.favorites,
                    onBack = { onBack() },
                    onGoToCharacter = { navigator.push(CharacterDetailScreen(it)) }
                )

                ScreenState.Error -> ErrorContainer(onRetry = {}, onBack = { onBack() })
                ScreenState.Loading -> Loading(onBack = { onBack() })
                else -> {}
            }
        }
    }
}