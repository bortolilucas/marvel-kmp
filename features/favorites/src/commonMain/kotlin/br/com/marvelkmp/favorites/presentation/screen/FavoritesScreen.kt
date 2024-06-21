package br.com.marvelkmp.favorites.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.marvelkmp.core.presentation.composables.error.ErrorContainer
import br.com.marvelkmp.core.presentation.composables.loading.Loading
import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.favorites.presentation.composables.Default
import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.navigation.utils.getScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

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
            screenModel.onEvent(FavoritesEvent.OnLaunch)
        }

        Column {
            when (state) {
                ScreenState.Default -> Default(
                    favorites = screenModelState.favorites,
                    onBack = { onBack() },
                    onGoToCharacter = {
                        navigator.push(
                            getScreenRegistry(
                                SharedScreen.CharacterDetails(
                                    it
                                )
                            )
                        )
                    }
                )

                ScreenState.Error -> ErrorContainer(
                    onRetry = { screenModel.onEvent(FavoritesEvent.OnRetry) },
                    onBack = { onBack() }
                )

                ScreenState.Loading -> Loading(onBack = { onBack() })
                else -> {}
            }
        }
    }
}