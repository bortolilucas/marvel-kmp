package features.home.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import core.presentation.theme.Theme
import features.character.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character,
    onClick: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = { onClick(character) }),
    ) {
        AsyncImage(
            model = character.images.sm,
            contentDescription = character.heroName,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.padding(Theme.spacing.medium)
        ) {
            Text(
                text = character.realName,
                style = Theme.typography.overline,
                color = Theme.colors.onSurface,
                modifier = Modifier.padding(bottom = Theme.spacing.extraSmall)
            )

            Text(
                text = character.heroName,
                style = Theme.typography.h3,
                color = Theme.colors.onSurface
            )
        }
    }
}