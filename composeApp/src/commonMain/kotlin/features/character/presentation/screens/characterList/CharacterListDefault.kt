package features.character.presentation.screens.characterList

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
import core.domain.model.Character
import core.presentation.composables.navigation.GoBackHeader
import core.presentation.mapper.asString
import core.presentation.model.CharacterFilter
import core.presentation.theme.Theme
import core.presentation.util.modifiers.getBottomSafePadding
import features.home.presentation.composables.CharacterListItem

@Composable
fun CharacterListDefault(
    type: CharacterFilter,
    characters: List<Character>,
    onCharacterClick: (Character) -> Unit,
    onGoBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
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
            columns = GridCells.Fixed(2),
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