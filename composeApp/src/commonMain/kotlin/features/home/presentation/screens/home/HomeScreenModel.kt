package features.home.presentation.screens.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.presentation.model.ScreenState
import features.home.domain.usecase.GetCharactersByTypeUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val getCharactersByType: GetCharactersByTypeUseCase
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
}