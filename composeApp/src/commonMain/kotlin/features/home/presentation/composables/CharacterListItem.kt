package features.home.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.theme.Theme
import coil3.compose.AsyncImage

@Composable
fun CharacterListItem(
    character: Character,
    onClick: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.6f)
            .shadow(Theme.spacing.small, Theme.shapes.large)
            .background(Theme.colors.surface)
            .clip(Theme.shapes.large)
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