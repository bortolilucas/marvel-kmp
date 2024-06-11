package br.com.marvelkmp.home.navigation

import br.com.marvelkmp.home.presentation.HomeScreen
import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.navigation.screenModule

val homeScreenNavigationModule = screenModule {
    register<SharedScreen.Home> { HomeScreen }
}