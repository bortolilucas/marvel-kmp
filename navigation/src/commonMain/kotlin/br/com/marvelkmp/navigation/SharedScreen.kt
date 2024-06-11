package br.com.marvelkmp.navigation

import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object Home : SharedScreen()
    object Favorites : SharedScreen()
    data class CharacterList(val type: CharacterFilter) : SharedScreen()
    data class CharacterDetails(val character: Character) : SharedScreen()

}
