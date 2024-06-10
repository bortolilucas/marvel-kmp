package br.com.marvelkmp.network.di

import br.com.marvelkmp.network.service.marvelApiService
import br.com.marvelkmp.network.service.superHeroApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("marvelHttpClient")) { marvelApiService }
    single(named("superHeroHttpClient")) { superHeroApiService }
}