package features.home.domain.model

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.model.CharacterFilter

data class CharacterSection(
    val characters: List<Character>,
    val type: CharacterFilter,
)
