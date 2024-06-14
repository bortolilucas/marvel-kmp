package br.com.marvelkmp.character.presentation.screens.characterList

import br.com.marvelkmp.core.presentation.model.CharacterFilter

sealed class CharacterListEvent {
    data class OnLaunch(val type: CharacterFilter) : CharacterListEvent()
    data class OnRetry(val type: CharacterFilter) : CharacterListEvent()
}