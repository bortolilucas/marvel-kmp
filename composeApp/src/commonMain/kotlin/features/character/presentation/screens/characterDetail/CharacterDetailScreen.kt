package features.character.presentation.screens.characterDetail

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import features.character.presentation.screens.characterDetail.composables.Default
import features.character.domain.model.Character

class CharacterDetailScreen(private val character: Character) : Screen {
    @Composable
    override fun Content() {
        val model = koinScreenModel<CharacterDetailScreenModel>()
        val navigator = LocalNavigator.currentOrThrow

        Default(onBack = { navigator.pop() })
    }
}