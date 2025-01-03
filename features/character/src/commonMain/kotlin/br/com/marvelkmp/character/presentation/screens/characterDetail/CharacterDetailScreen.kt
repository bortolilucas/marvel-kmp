package br.com.marvelkmp.character.presentation.screens.characterDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import br.com.marvelkmp.character.presentation.screens.characterDetail.composables.CharacterDetailsDefault
import br.com.marvelkmp.character.presentation.screens.characterDetail.model.CharacterDetailEvent
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.composables.error.ErrorContainer
import br.com.marvelkmp.core.presentation.composables.loading.Loading
import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.di.koinScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class CharacterDetailScreen(private val character: Character) : Screen {
    @Composable
    override fun Content() {
        val model = koinScreenModel<CharacterDetailScreenModel>()
        val state by model.state.collectAsState()

        val isFavorite = remember { mutableStateOf(false) }

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            model.onEvent(CharacterDetailEvent.OnLaunch(character))
        }

        LaunchedEffect(key1 = model.state.value.isFavorite) {
            isFavorite.value = model.state.value.isFavorite
        }

        when (state.state) {
            ScreenState.Default -> CharacterDetailsDefault(
                onBack = { navigator.pop() },
                onToggleFavorite = { model.onEvent(CharacterDetailEvent.OnToggleFavorite(character)) },
                character = model.state.value.character ?: return,
                isFavorite = isFavorite.value
            )

            ScreenState.Loading -> Loading(onBack = { navigator.pop() })

            ScreenState.Error -> ErrorContainer(
                onBack = { navigator.pop() },
                onRetry = { model.onEvent(CharacterDetailEvent.OnRetry(character)) })

            else -> {}
        }
    }
}