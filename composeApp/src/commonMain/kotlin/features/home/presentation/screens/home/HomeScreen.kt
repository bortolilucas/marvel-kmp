package features.home.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import core.presentation.composables.error.ErrorContainer
import core.presentation.composables.loading.Loading
import core.presentation.model.ScreenState
import features.character.presentation.screens.characterDetail.CharacterDetailScreen
import features.home.presentation.composables.Header

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val model = koinScreenModel<HomeScreenModel>()
        val state by model.state.collectAsState()

        Column(modifier = Modifier.fillMaxSize()) {
            Header(
                onMenuClick = {},
                onSearchClick = {}
            )

            when (state.state) {
                ScreenState.Default -> {
                    HomeDefault(
                        state = state,
                        onCharacterClick = { navigator.push(CharacterDetailScreen(it)) },
                        onCharacterTypeClick = {}
                    )
                }

                ScreenState.Loading -> Loading()
                ScreenState.Error -> ErrorContainer(onRetry = model::loadData)
            }
        }
    }
}