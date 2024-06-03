package features.character.di

import features.character.data.repository.CharacterRepositoryImpl
import features.character.data.service.CharacterService
import features.character.data.service.CharacterServiceImpl
import features.character.domain.repository.CharacterRepository
import features.character.domain.usecase.GetCharactersByTypeUseCase
import features.home.presentation.screens.home.HomeScreenModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val characterModule = module {
    factory { HomeScreenModel(get()) }
    single<CharacterService> { CharacterServiceImpl(get(named("superHeroHttpClient"))) }
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
    factory { GetCharactersByTypeUseCase(get()) }
}