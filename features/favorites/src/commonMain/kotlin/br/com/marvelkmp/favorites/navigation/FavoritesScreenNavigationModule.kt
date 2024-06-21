package br.com.marvelkmp.favorites.navigation

import br.com.marvelkmp.favorites.presentation.screen.FavoritesScreen
import br.com.marvelkmp.navigation.SharedScreen
import cafe.adriel.voyager.core.registry.screenModule

val favoritesScreenNavigationModule = screenModule {
    register<SharedScreen.Favorites> { FavoritesScreen }
}