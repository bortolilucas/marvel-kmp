package br.com.marvelkmp.character.presentation.screens.characterDetail.model

import br.com.marvelkmp.core.data.model.marvel.CharacterDetails
import br.com.marvelkmp.core.presentation.model.ScreenState

data class CharacterDetailState(
    val state: ScreenState = ScreenState.Loading,
    val character: CharacterDetails? = null,
    val isFavorite: Boolean = false
)
