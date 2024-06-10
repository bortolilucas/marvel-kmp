package di

import br.com.marvelkmp.network.di.networkModule
import features.character.di.characterModule
import features.favorites.di.favoritesModule
import features.home.di.homeModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
) {
    val modules = listOf(
        networkModule,
        homeModule,
        characterModule,
        favoritesModule,
        characterModule,
        nativeModule
    )

    startKoin {
        appDeclaration()
        modules(modules)
    }
}