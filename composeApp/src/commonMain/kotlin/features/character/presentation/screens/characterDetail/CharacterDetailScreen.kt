package features.character.presentation.screens.characterDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import core.domain.model.Character
import core.presentation.composables.error.ErrorContainer
import core.presentation.composables.loading.Loading
import core.presentation.model.ScreenState
import features.character.presentation.screens.characterDetail.composables.CharacterDetailsDefault

class CharacterDetailScreen(private val character: Character) : Screen {
    @Composable
    override fun Content() {
        val model = koinScreenModel<CharacterDetailScreenModel>()
        val state by model.state.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            model.getCharacterDetails(character)
        }

        when (state.state) {
            ScreenState.Default -> CharacterDetailsDefault(
                onBack = { navigator.pop() },
                character = model.state.value.character ?: return
            )

            ScreenState.Loading -> Loading(onBack = { navigator.pop() })

            ScreenState.Error -> ErrorContainer(
                onBack = { navigator.pop() },
                onRetry = { model.getCharacterDetails(character) })

            else -> {}
        }
    }
}