package br.com.marvelkmp.favorites.di

import br.com.marvelkmp.favorites.data.repository.FavoritesRepository
import br.com.marvelkmp.favorites.domain.repository.FavoritesRepositoryImpl
import br.com.marvelkmp.favorites.domain.usecase.GetFavoritesUseCase
import br.com.marvelkmp.favorites.presentation.screen.FavoritesScreenModel
import org.koin.dsl.module


val favoritesModule = module {
    single<FavoritesRepository> { FavoritesRepositoryImpl(get()) }
    factory { GetFavoritesUseCase(get()) }
    factory { FavoritesScreenModel(get()) }
}