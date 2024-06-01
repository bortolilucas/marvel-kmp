package features.home.di

import features.character.presentation.screens.characterDetail.CharacterDetailScreenModel
import org.koin.dsl.module

val homeModule = module {
    factory { CharacterDetailScreenModel() }
}