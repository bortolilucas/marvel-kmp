package network.di

import network.service.marvelApiService
import network.service.superHeroApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("marvelHttpClient")) { marvelApiService }
    single(named("superHeroHttpClient")) { superHeroApiService }
}