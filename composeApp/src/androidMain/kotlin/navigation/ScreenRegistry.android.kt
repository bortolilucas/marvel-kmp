package navigation

import br.com.marvelkmp.character.navigation.characterScreenNavigationModule
import br.com.marvelkmp.favorites.navigation.favoritesScreenNavigationModule
import br.com.marvelkmp.home.navigation.homeScreenNavigationModule
import br.com.marvelkmp.splash.navigation.splashScreenNavigationModule
import cafe.adriel.voyager.core.registry.ScreenRegistry

actual fun screenRegistry() = ScreenRegistry {
    splashScreenNavigationModule()
    characterScreenNavigationModule()
    homeScreenNavigationModule()
    favoritesScreenNavigationModule()
}