package br.com.marvelkmp.core.di

import br.com.marvelkmp.core.data.repository.CharacterDetailRepositoryImpl
import br.com.marvelkmp.core.data.repository.CharacterListRepositoryImpl
import br.com.marvelkmp.core.data.service.CharacterDetailsService
import br.com.marvelkmp.core.data.service.CharacterDetailsServiceImpl
import br.com.marvelkmp.core.data.service.CharacterListService
import br.com.marvelkmp.core.data.service.CharacterListServiceImpl
import br.com.marvelkmp.core.domain.repository.CharacterDetailRepository
import br.com.marvelkmp.core.domain.repository.CharacterListRepository
import br.com.marvelkmp.core.domain.usecase.AddFavoriteUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coreModule = module {
    single<CharacterListService> { CharacterListServiceImpl(get(named("superHeroHttpClient"))) }
    single<CharacterListRepository> { CharacterListRepositoryImpl(get()) }
    single<CharacterDetailsService> { CharacterDetailsServiceImpl(get(named("marvelHttpClient"))) }
    single<CharacterDetailRepository> { CharacterDetailRepositoryImpl(get(), get()) }
    factory<AddFavoriteUseCase> { AddFavoriteUseCase(get()) }
}