package features.character.presentation.screens.characterList

import core.domain.model.Character
import core.presentation.model.ScreenState

data class CharacterListState(
    val state: ScreenState = ScreenState.Loading,
    val characters: List<Character> = emptyList()
)
