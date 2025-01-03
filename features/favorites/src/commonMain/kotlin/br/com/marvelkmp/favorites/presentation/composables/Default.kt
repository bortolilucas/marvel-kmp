package br.com.marvelkmp.favorites.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.composables.character.CharacterListItem
import br.com.marvelkmp.core.presentation.composables.navigation.GoBackHeader
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.modifiers.getBottomSafePadding
import marvelkmp.features.favorites.generated.resources.Res
import marvelkmp.features.favorites.generated.resources.favorites
import marvelkmp.features.favorites.generated.resources.no_favorites
import org.jetbrains.compose.resources.stringResource

@Composable
fun Default(
    favorites: List<Character>,
    onBack: () -> Unit,
    onGoToCharacter: (character: Character) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.background)
    ) {
        GoBackHeader(onGoBack = { onBack() }, tint = Theme.colors.primaryVariant)
        Text(
            modifier = Modifier.padding(
                start = Theme.spacing.large,
                end = Theme.spacing.large,
                top = Theme.spacing.small,
                bottom = Theme.spacing.extraMedium
            ),
            text = stringResource(Res.string.favorites),
            color = Theme.colors.onBackground,
            style = Theme.typography.h1
        )
        if (favorites.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.extraLarge),
                horizontalArrangement = Arrangement.spacedBy(Theme.spacing.large),
                contentPadding = PaddingValues(
                    start = Theme.spacing.large,
                    end = Theme.spacing.large,
                    top = Theme.spacing.medium,
                    bottom = Theme.spacing.big + getBottomSafePadding(),
                ),
            ) {
                items(favorites) { character ->
                    CharacterListItem(
                        character = character,
                        onClick = { onGoToCharacter(character) }
                    )
                }
            }
        } else {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(Res.string.no_favorites),
                    color = Theme.colors.onBackground,
                    style = Theme.typography.h3
                )
            }
        }
    }
}