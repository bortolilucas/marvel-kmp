package features.character.presentation.screens.characterDetail.model

import br.com.marvelkmp.core.presentation.model.ScreenState
import features.character.data.model.CharacterDetails

data class CharacterDetailState(
    val state: ScreenState = ScreenState.Loading,
    val character: CharacterDetails? = null,
    val isFavorite: Boolean = false
)
