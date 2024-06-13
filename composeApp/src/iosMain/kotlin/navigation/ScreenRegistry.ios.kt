package navigation

import br.com.marvelkmp.character.navigation.characterScreenNavigationModule
import br.com.marvelkmp.favorites.navigation.favoritesScreenNavigationModule
import br.com.marvelkmp.home.navigation.homeScreenNavigationModule
import cafe.adriel.voyager.core.registry.ScreenRegistry

actual fun screenRegistry() = ScreenRegistry {
    characterScreenNavigationModule()
    homeScreenNavigationModule()
    favoritesScreenNavigationModule()
}