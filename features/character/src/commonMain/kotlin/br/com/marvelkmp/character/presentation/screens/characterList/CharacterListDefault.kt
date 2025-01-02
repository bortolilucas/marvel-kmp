package br.com.marvelkmp.character.presentation.screens.characterList

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.composables.character.CharacterListItem
import br.com.marvelkmp.core.presentation.composables.navigation.GoBackHeader
import br.com.marvelkmp.core.presentation.mapper.asString
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.modifiers.getBottomSafePadding

@Composable
fun CharacterListDefault(
    type: CharacterFilter,
    characters: List<Character>,
    onCharacterClick: (Character) -> Unit,
    onGoBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.background)
    ) {
        GoBackHeader(onGoBack = onGoBack)

        Text(
            text = type.asString(),
            style = Theme.typography.h2,
            fontWeight = FontWeight.Bold,
            color = Theme.colors.primary,
            modifier = Modifier.padding(
                start = Theme.spacing.large,
                end = Theme.spacing.large,
                top = Theme.spacing.small,
                bottom = Theme.spacing.extraMedium
            )
        )

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
            items(characters) {
                CharacterListItem(
                    character = it,
                    onClick = onCharacterClick
                )
            }
        }
    }
}