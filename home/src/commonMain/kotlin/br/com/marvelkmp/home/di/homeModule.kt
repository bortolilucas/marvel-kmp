package br.com.marvelkmp.home.di

import br.com.marvelkmp.home.data.repository.HomeRepositoryImpl
import br.com.marvelkmp.home.data.service.HomeService
import br.com.marvelkmp.home.data.service.HomeServiceImpl
import br.com.marvelkmp.home.domain.repository.HomeRepository
import br.com.marvelkmp.home.domain.usecase.GetCharactersByNameUseCase
import br.com.marvelkmp.home.domain.usecase.GetCharactersByTypeUseCase
import br.com.marvelkmp.home.presentation.HomeScreenModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val homeModule = module {
    factory { HomeScreenModel(get(), get()) }
    single<HomeService> { HomeServiceImpl(get(named("superHeroHttpClient"))) }
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    factory { GetCharactersByTypeUseCase(get()) }
    factory { GetCharactersByNameUseCase(get()) }
}