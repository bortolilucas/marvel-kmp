package navigation

import br.com.marvelkmp.navigation.SharedScreen
import cafe.adriel.voyager.core.registry.ScreenRegistry
import features.character.presentation.screens.characterDetail.CharacterDetailScreen
import features.character.presentation.screens.characterList.CharacterListScreen
import features.favorites.presentation.screen.FavoritesScreen
import features.home.presentation.screens.home.HomeScreen

actual fun screenRegistry() = ScreenRegistry {
    register<SharedScreen.Home> { HomeScreen }
    register<SharedScreen.Favorites> { FavoritesScreen }
    register<SharedScreen.CharacterDetails> { CharacterDetailScreen(it.character) }
    register<SharedScreen.CharacterList> { CharacterListScreen(it.type) }
}