package navigation

import br.com.marvelkmp.home.navigation.homeScreenNavigationModule
import br.com.marvelkmp.navigation.SharedScreen
import cafe.adriel.voyager.core.registry.ScreenRegistry
import features.character.presentation.screens.characterDetail.CharacterDetailScreen
import features.character.presentation.screens.characterList.CharacterListScreen
import features.favorites.presentation.screen.FavoritesScreen

actual fun screenRegistry() = ScreenRegistry {
    register<SharedScreen.Favorites> { FavoritesScreen }
    register<SharedScreen.CharacterDetails> { CharacterDetailScreen(it.character) }
    register<SharedScreen.CharacterList> { CharacterListScreen(it.type) }
    homeScreenNavigationModule()
}