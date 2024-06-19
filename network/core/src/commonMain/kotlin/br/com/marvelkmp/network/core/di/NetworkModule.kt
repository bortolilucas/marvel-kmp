package br.com.marvelkmp.network.core.di

import br.com.marvelkmp.network.core.service.marvelApiService
import br.com.marvelkmp.network.core.service.superHeroApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("marvelHttpClient")) { marvelApiService }
    single(named("superHeroHttpClient")) { superHeroApiService }
}