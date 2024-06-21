package br.com.marvelkmp.home.di

import br.com.marvelkmp.home.domain.usecase.GetCharactersByNameUseCase
import br.com.marvelkmp.home.domain.usecase.GetCharactersByTypeUseCase
import br.com.marvelkmp.home.presentation.HomeScreenModel
import org.koin.dsl.module

val homeModule = module {
    factory { HomeScreenModel(get(), get()) }
    factory { GetCharactersByTypeUseCase(get()) }
    factory { GetCharactersByNameUseCase(get()) }
}