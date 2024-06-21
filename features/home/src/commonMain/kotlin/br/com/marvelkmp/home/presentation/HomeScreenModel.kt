package br.com.marvelkmp.home.presentation

import br.com.marvelkmp.core.presentation.model.ScreenState
import br.com.marvelkmp.home.domain.usecase.GetCharactersByNameUseCase
import br.com.marvelkmp.home.domain.usecase.GetCharactersByTypeUseCase
import br.com.marvelkmp.home.presentation.model.HomeState
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val getCharactersByType: GetCharactersByTypeUseCase,
    private val getCharactersByName: GetCharactersByNameUseCase
) : StateScreenModel<HomeState>(HomeState()) {
    init {
        loadData()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnToggleSearchInput -> onToggleSearchInput()
            HomeEvent.OnRetry -> loadData()
            is HomeEvent.OnSearch -> onSearch(event.search)
        }
    }

    private fun loadData() = screenModelScope.launch {
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

    private fun onToggleSearchInput() {
        mutableState.update {
            it.copy(
                showSearchInput = !it.showSearchInput,
                state = if (!it.showSearchInput) ScreenState.Search else ScreenState.Default,
                searchResults = emptyList(),
                hasNotFoundResults = false
            )
        }
    }

    private fun onSearch(value: String) = screenModelScope.launch {
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