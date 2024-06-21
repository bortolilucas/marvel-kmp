package br.com.marvelkmp.character.presentation.screens.characterDetail.model

import br.com.marvelkmp.core.domain.model.Character

sealed class CharacterDetailEvent {
    data class OnLaunch(val character: Character) : CharacterDetailEvent()
    data class OnToggleFavorite(val character: Character) : CharacterDetailEvent()
    data class OnRetry(val character: Character) : CharacterDetailEvent()
}