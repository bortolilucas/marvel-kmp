package features.character.presentation.screens.characterList

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.presentation.model.CharacterFilter
import core.presentation.model.ScreenState
import features.character.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterListScreenModel(
    private val getCharacterList: GetCharacterListUseCase,
) : StateScreenModel<CharacterListState>(CharacterListState()) {
    fun loadCharacters(type: CharacterFilter) {
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