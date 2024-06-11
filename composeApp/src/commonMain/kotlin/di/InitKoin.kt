package di

import br.com.marvelkmp.home.di.homeModule
import br.com.marvelkmp.network.di.networkModule
import features.character.di.characterModule
import features.favorites.di.favoritesModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    additionalModules: List<Module> = emptyList(),
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
        modules(modules + additionalModules)
    }
}