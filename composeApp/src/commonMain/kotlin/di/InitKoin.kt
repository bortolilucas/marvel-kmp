package di

import network.di.networkModule
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = listOf(
        networkModule
    )

    startKoin {
        modules(modules)
    }
}