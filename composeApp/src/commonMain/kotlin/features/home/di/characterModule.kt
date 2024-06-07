package features.home.di

import features.home.data.repository.CharacterRepositoryImpl
import features.home.domain.repository.CharacterRepository
import features.home.domain.usecase.GetCharactersByTypeUseCase
import features.home.data.service.CharacterService
import features.home.data.service.CharacterServiceImpl
import features.home.domain.usecase.GetCharactersByNameUseCase
import features.home.presentation.screens.home.HomeScreenModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val homeModule = module {
    factory { HomeScreenModel(get(), get(), get()) }
    single<CharacterService> { CharacterServiceImpl(get(named("superHeroHttpClient"))) }
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
    factory { GetCharactersByTypeUseCase(get()) }
    factory { GetCharactersByNameUseCase(get()) }
}