package features.favorites.di

import features.favorites.data.repository.FavoritesRepository
import features.favorites.domain.repository.FavoritesRepositoryImpl
import features.favorites.domain.usecase.GetFavoritesUseCase
import features.favorites.presentation.screen.FavoritesScreenModel
import org.koin.dsl.module

val favoritesModule = module {
    single<FavoritesRepository> { FavoritesRepositoryImpl(get()) }
    factory { GetFavoritesUseCase(get()) }
    factory { FavoritesScreenModel(get()) }
}