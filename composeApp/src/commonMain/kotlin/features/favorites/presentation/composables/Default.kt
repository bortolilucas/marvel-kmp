package features.favorites.presentation.composables

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
import core.domain.model.Character
import core.domain.model.CharacterAlignment
import core.domain.model.CharacterImages
import core.presentation.composables.navigation.GoBackHeader
import core.presentation.theme.Theme
import core.presentation.util.modifiers.getBottomSafePadding
import features.home.presentation.composables.CharacterListItem

@Composable
fun Default(onBack: () -> Unit) {
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
            text = "Favorites",
            style = Theme.typography.h1
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
            items(
                listOf(
                    Character(
                        id = 1,
                        heroName = "",
                        realName = "",
                        alignment = CharacterAlignment.HERO,
                        images = CharacterImages(sm = "https://m.media-amazon.com/images/I/619oMCm39HL.jpg"),
                        gender = ""
                    ),
                    Character(
                        id = 1,
                        heroName = "",
                        realName = "",
                        alignment = CharacterAlignment.HERO,
                        images = CharacterImages(sm = "https://m.media-amazon.com/images/I/619oMCm39HL.jpg"),
                        gender = ""
                    )
                )
            ) {
                CharacterListItem(
                    character = it,
                    onClick = {

                    }
                )
            }
        }
    }
}