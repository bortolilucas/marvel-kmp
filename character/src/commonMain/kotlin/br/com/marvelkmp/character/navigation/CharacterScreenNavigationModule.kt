package br.com.marvelkmp.character.navigation

import br.com.marvelkmp.character.presentation.screens.characterDetail.CharacterDetailScreen
import br.com.marvelkmp.character.presentation.screens.characterList.CharacterListScreen
import br.com.marvelkmp.navigation.SharedScreen
import cafe.adriel.voyager.core.registry.screenModule

val characterScreenNavigationModule = screenModule {
    register<SharedScreen.CharacterDetails> { CharacterDetailScreen(it.character) }
    register<SharedScreen.CharacterList> { CharacterListScreen(it.type) }
}