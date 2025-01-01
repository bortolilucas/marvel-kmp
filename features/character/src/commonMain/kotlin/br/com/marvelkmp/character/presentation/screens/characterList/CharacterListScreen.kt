package br.com.marvelkmp.character.presentation.screens.characterList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.marvelkmp.core.presentation.composables.error.ErrorContainer
import br.com.marvelkmp.core.presentation.composables.loading.Loading
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.navigation.utils.getScreenRegistry
import br.com.marvelkmp.di.koinScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class CharacterListScreen(private val type: CharacterFilter) : Screen {
    @Composable
    override fun Content() {
        val model = koinScreenModel<CharacterListScreenModel>()
        val state by model.state.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            model.onEvent(CharacterListEvent.OnLaunch(type))
        }

        when (state.state) {
            ScreenState.Default -> CharacterListDefault(
                type = type,
                characters = state.characters,
                onGoBack = navigator::pop,
                onCharacterClick = {
                    navigator.push(
                        getScreenRegistry(
                            SharedScreen.CharacterDetails(
                                it
                            )
                        )
                    )
                }
            )

            ScreenState.Loading -> Loading(onBack = navigator::pop)

            ScreenState.Error -> ErrorContainer(
                onBack = navigator::pop,
                onRetry = { model.onEvent(CharacterListEvent.OnRetry(type)) }
            )

            else -> {}
        }
    }
}