package br.com.marvelkmp.splash.navigation

import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.splash.presentation.screens.splash.SplashScreen
import cafe.adriel.voyager.core.registry.screenModule

val splashScreenNavigationModule = screenModule {
    register<SharedScreen.Splash> { SplashScreen }
}