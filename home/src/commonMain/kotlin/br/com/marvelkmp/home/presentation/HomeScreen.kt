package br.com.marvelkmp.home.presentation

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
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.composables.error.ErrorContainer
import br.com.marvelkmp.core.presentation.composables.loading.Loading
import br.com.marvelkmp.core.presentation.composables.navigation.Header
import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.home.presentation.composables.HomeDefault
import br.com.marvelkmp.home.presentation.composables.search.Search
import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.navigation.utils.getScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
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

        fun onNavigateToCharacterDetails(character: Character) {
            navigator.push(getScreenRegistry(SharedScreen.CharacterDetails(character)))
        }

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
                onMenuClick = { navigator.push(getScreenRegistry(SharedScreen.Favorites)) },
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
                        onCharacterClick = {
                            onNavigateToCharacterDetails(it)
                        },
                        onCharacterTypeClick = {
                            navigator.push(
                                getScreenRegistry(
                                    SharedScreen.CharacterList(
                                        it
                                    )
                                )
                            )
                        }
                    )
                }

                ScreenState.Loading -> Loading()
                ScreenState.Error -> ErrorContainer(onRetry = model::loadData)
                ScreenState.Search -> Search(
                    searchInput = searchInput,
                    state = state,
                    onChangeSearchInput = { searchInput = it },
                    onGoToCharacterDetails = {
                        onNavigateToCharacterDetails(it)
                    }
                )
            }
        }
    }
}