package di

import features.character.di.characterModule
import features.favorites.di.favoritesModule
import features.home.di.homeModule
import network.di.networkModule
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = listOf(
        networkModule,
        homeModule,
        characterModule,
        favoritesModule
    )

    startKoin {
        modules(modules)
    }
}