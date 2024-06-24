package br.com.marvelkmp.character.di

import br.com.marvelkmp.character.domain.usecase.GetCharacterComicsUseCase
import br.com.marvelkmp.character.domain.usecase.GetCharacterDetailsUseCase
import br.com.marvelkmp.character.domain.usecase.GetCharacterListUseCaseImpl
import br.com.marvelkmp.character.domain.usecase.RemoveFavoriteUseCase
import br.com.marvelkmp.character.domain.usecase.VerifyIsFavoriteUseCase
import br.com.marvelkmp.character.presentation.screens.characterDetail.CharacterDetailScreenModel
import br.com.marvelkmp.character.presentation.screens.characterList.CharacterListScreenModel
import org.koin.dsl.module

val characterModule = module {
    factory { CharacterDetailScreenModel(get(), get(), get(), get(), get()) }
    factory { GetCharacterDetailsUseCase(get()) }
    factory { GetCharacterComicsUseCase(get()) }
    factory { GetCharacterListUseCaseImpl(get()) }
    factory { VerifyIsFavoriteUseCase(get()) }
    factory { RemoveFavoriteUseCase(get()) }
    factory { CharacterListScreenModel(get()) }
}