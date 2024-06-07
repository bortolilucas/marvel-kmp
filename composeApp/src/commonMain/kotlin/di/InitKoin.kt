package di

import appModule
import features.character.di.characterModule
import features.home.di.homeModule
import network.di.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
) {
    val modules = listOf(
        networkModule,
        homeModule,
        characterModule,
        appModule
    )

    startKoin {
        appDeclaration()
        modules(modules)
    }
}