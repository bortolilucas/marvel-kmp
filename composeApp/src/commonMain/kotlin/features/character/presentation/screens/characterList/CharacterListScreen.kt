package features.character.presentation.screens.characterList

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
import core.presentation.model.CharacterFilter
import core.presentation.model.ScreenState
import features.character.presentation.screens.characterDetail.CharacterDetailScreen

class CharacterListScreen(private val type: CharacterFilter) : Screen {
    @Composable
    override fun Content() {
        val model = koinScreenModel<CharacterListScreenModel>()
        val state by model.state.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            model.loadCharacters(type)
        }

        when (state.state) {
            ScreenState.Default -> CharacterListDefault(
                type = type,
                characters = state.characters,
                onGoBack = navigator::pop,
                onCharacterClick = { navigator.push(CharacterDetailScreen(it)) }
            )

            ScreenState.Loading -> Loading(onBack = navigator::pop)

            ScreenState.Error -> ErrorContainer(
                onBack = navigator::pop,
                onRetry = { model.loadCharacters(type) }
            )
            else ->{}
        }
    }
}