package di

import br.com.marvelkmp.character.di.characterModule
import br.com.marvelkmp.core.di.coreModule
import br.com.marvelkmp.favorites.di.favoritesModule
import br.com.marvelkmp.home.di.homeModule
import br.com.marvelkmp.network.di.networkModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    additionalModules: List<Module> = emptyList(),
    appDeclaration: KoinAppDeclaration = {}
) {
    val modules = listOf(
        coreModule,
        networkModule,
        homeModule,
        characterModule,
        favoritesModule,
        nativeModule
    )

    startKoin {
        appDeclaration()
        modules(modules + additionalModules)
    }
}