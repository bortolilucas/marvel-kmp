package navigation

import br.com.marvelkmp.character.navigation.characterScreenNavigationModule
import br.com.marvelkmp.home.navigation.homeScreenNavigationModule
import br.com.marvelkmp.navigation.SharedScreen
import cafe.adriel.voyager.core.registry.ScreenRegistry
import features.favorites.presentation.screen.FavoritesScreen

actual fun screenRegistry() = ScreenRegistry {
    register<SharedScreen.Favorites> { FavoritesScreen }
    characterScreenNavigationModule()
    homeScreenNavigationModule()
}