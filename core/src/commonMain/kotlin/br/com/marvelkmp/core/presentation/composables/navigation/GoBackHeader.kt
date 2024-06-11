package br.com.marvelkmp.core.presentation.composables.navigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.marvelkmp.core.presentation.composables.statusbar.StatusBarEffect
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.modifiers.safePadding
import marvelkmp.core.generated.resources.Res
import marvelkmp.core.generated.resources.filledHeart
import marvelkmp.core.generated.resources.heart
import org.jetbrains.compose.resources.painterResource

@Composable
fun GoBackHeader(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = Theme.colors.primaryVariant,
    isStatusAppearanceLight: Boolean = !isSystemInDarkTheme(),
    showFavoriteButton: Boolean = false,
    isFavorited: Boolean = false,
    onToggleFavorite: (() -> Unit)? = null,
) {
    StatusBarEffect(isAppearanceLight = isStatusAppearanceLight)

    Row(
        modifier = modifier
            .safePadding(WindowInsetsSides.Top)
            .padding(
                horizontal = Theme.spacing.extraMedium,
                vertical = Theme.spacing.small
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onGoBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = tint
            )
        }
        if (showFavoriteButton)
            IconButton(onClick = { onToggleFavorite?.invoke() }) {
                Icon(
                    painter = if (isFavorited) painterResource(Res.drawable.heart) else painterResource(
                        Res.drawable.filledHeart
                    ),
                    contentDescription = null,
                    tint = if (isFavorited) Theme.colors.primary else Theme.colors.onSurface
                )
            }
    }
}