package features.favorites.di

import features.favorites.presentation.screen.FavoritesScreenModel
import org.koin.dsl.module

val favoritesModule = module {
    single { FavoritesScreenModel() }
}