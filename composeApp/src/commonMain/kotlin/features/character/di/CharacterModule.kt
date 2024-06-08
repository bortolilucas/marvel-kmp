package features.character.di

import features.character.data.repository.CharacterDetailRepositoryImpl
import features.character.data.service.CharacterDetailsService
import features.character.data.service.CharacterDetailsServiceImpl
import features.character.domain.repository.CharacterDetailRepository
import features.character.domain.usecase.GetCharacterComicsUseCase
import features.character.domain.usecase.GetCharacterDetailsUseCase
import features.character.domain.usecase.GetCharacterListUseCase
import features.character.domain.usecase.RemoveFavoriteUseCase
import features.character.domain.usecase.VerifyIsFavoriteUseCase
import features.character.presentation.screens.characterDetail.CharacterDetailScreenModel
import features.character.presentation.screens.characterList.CharacterListScreenModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val characterModule = module {
    factory { CharacterDetailScreenModel(get(), get(), get(), get(), get()) }
    single<CharacterDetailsService> { CharacterDetailsServiceImpl(get(named("marvelHttpClient"))) }
    single<CharacterDetailRepository> { CharacterDetailRepositoryImpl(get(), get()) }
    factory { GetCharacterDetailsUseCase(get()) }
    factory { GetCharacterComicsUseCase(get()) }
    factory { GetCharacterListUseCase(get()) }
    factory { VerifyIsFavoriteUseCase(get()) }
    factory { RemoveFavoriteUseCase(get()) }
    factory { CharacterListScreenModel(get()) }
}