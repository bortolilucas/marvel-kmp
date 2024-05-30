package features.home.di

import features.character.ui.screens.characterDetail.CharacterDetailScreenModel
import org.koin.dsl.module

val homeModule = module {
    factory { CharacterDetailScreenModel() }
}