package br.com.marvelkmp.character.presentation.screens.characterList

import br.com.marvelkmp.character.domain.usecase.GetCharacterListUseCase
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.model.ScreenState
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterListScreenModel(
    private val getCharacterList: GetCharacterListUseCase,
) : StateScreenModel<CharacterListState>(CharacterListState()) {
    fun onEvent(event: CharacterListEvent) {
        when (event) {
            is CharacterListEvent.OnLaunch -> loadCharacters(event.type)
            is CharacterListEvent.OnRetry -> loadCharacters(event.type)
        }
    }

    private fun loadCharacters(type: CharacterFilter) {
        screenModelScope.launch {
            mutableState.update { it.copy(state = ScreenState.Loading) }

            getCharacterList(type)
                .onSuccess { characterList ->
                    mutableState.update {
                        it.copy(
                            state = ScreenState.Default,
                            characters = characterList
                        )
                    }
                }
                .onFailure {
                    mutableState.update {
                        it.copy(state = ScreenState.Error)
                    }
                }
        }
    }
}