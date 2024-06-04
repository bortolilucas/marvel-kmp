package di

import features.home.di.homeModule
import network.di.networkModule
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = listOf(
        networkModule,
        homeModule,
    )

    startKoin {
        modules(modules)
    }
}