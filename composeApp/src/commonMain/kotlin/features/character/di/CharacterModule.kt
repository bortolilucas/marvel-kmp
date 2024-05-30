package features.character.di

import features.home.ui.screens.home.HomeScreenModel
import org.koin.dsl.module

val characterModule = module {
    factory { HomeScreenModel() }
}