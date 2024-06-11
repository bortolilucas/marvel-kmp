package features.home.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.marvelkmp.core.presentation.composables.error.ErrorContainer
import br.com.marvelkmp.core.presentation.composables.loading.Loading
import br.com.marvelkmp.core.presentation.composables.navigation.Header
import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.core.presentation.theme.Theme
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import features.character.presentation.screens.characterDetail.CharacterDetailScreen
import features.character.presentation.screens.characterList.CharacterListScreen
import features.favorites.presentation.screen.FavoritesScreen
import features.home.presentation.composables.search.Search
import kotlinx.coroutines.delay

const val DEBOUNCE_TIMEOUT = 1000L

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val model = koinScreenModel<HomeScreenModel>()
        val state by model.state.collectAsState()

        val showSearchInput = model.state.value.showSearchInput

        var searchInput by rememberSaveable { mutableStateOf("") }

        LaunchedEffect(key1 = searchInput) {
            if (showSearchInput && searchInput.isNotEmpty()) {
                delay(DEBOUNCE_TIMEOUT)
                model.onSearch(searchInput)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
        ) {
            Header(
                onMenuClick = { navigator.push(FavoritesScreen) },
                isSearchVisible = showSearchInput,
                onSearchClick = {
                    if (state.state is ScreenState.Loading) return@Header

                    if (searchInput.isNotEmpty()) searchInput = ""
                    model.onToggleSearchInput()
                }
            )

            when (state.state) {
                ScreenState.Default -> {
                    HomeDefault(
                        state = state,
                        onCharacterClick = { navigator.push(CharacterDetailScreen(it)) },
                        onCharacterTypeClick = { navigator.push(CharacterListScreen(it)) }
                    )
                }

                ScreenState.Loading -> Loading()
                ScreenState.Error -> ErrorContainer(onRetry = model::loadData)
                ScreenState.Search -> Search(
                    searchInput = searchInput,
                    state = state,
                    onChangeSearchInput = { searchInput = it },
                    onGoToCharacterDetails = { navigator.push(CharacterDetailScreen(it)) }
                )
            }
        }
    }
}