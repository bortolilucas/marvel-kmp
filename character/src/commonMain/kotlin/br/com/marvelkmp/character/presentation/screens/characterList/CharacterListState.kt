package br.com.marvelkmp.character.presentation.screens.characterList

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.model.ScreenState

data class CharacterListState(
    val state: ScreenState = ScreenState.Loading,
    val characters: List<Character> = emptyList()
)
