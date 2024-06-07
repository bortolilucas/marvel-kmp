package features.home.presentation.screens.home

import br.com.marvelkmp.app.MarvelDatabase
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.presentation.model.ScreenState
import database.Database
import features.home.domain.usecase.GetCharactersByNameUseCase
import features.home.domain.usecase.GetCharactersByTypeUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val getCharactersByType: GetCharactersByTypeUseCase,
    private val getCharactersByName: GetCharactersByNameUseCase,
    private val database: Database
) : StateScreenModel<HomeState>(HomeState()) {
    init {
        loadData()
    }

    fun loadData() = screenModelScope.launch {
        mutableState.update { it.copy(state = ScreenState.Loading) }

        getCharactersByType()
            .onSuccess { characterTypes ->
                mutableState.update {
                    it.copy(
                        state = ScreenState.Default,
                        sections = characterTypes
                    )
                }
            }
            .onFailure {
                mutableState.update { it.copy(state = ScreenState.Error) }
            }
    }

    fun onToggleSearchInput() {
        mutableState.update {
            it.copy(
                showSearchInput = !it.showSearchInput,
                state = if (!it.showSearchInput) ScreenState.Search else ScreenState.Default,
                searchResults = emptyList(),
                hasNotFoundResults = false
            )
        }
    }

    fun onSearch(value: String) = screenModelScope.launch {
        getCharactersByName(value)
            .onSuccess { characters ->
                mutableState.update {
                    it.copy(
                        searchResults = characters,
                        hasNotFoundResults = characters.isEmpty()
                    )
                }
            }
            .onFailure {
                mutableState.update { it.copy(state = ScreenState.Error) }
            }
    }
}