package core.presentation.composables.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import core.presentation.theme.Theme
import core.presentation.util.modifiers.safePadding

@Composable
fun GoBackHeader(
    onGoBack: () -> Unit,
    tint: Color = Theme.colors.primaryVariant,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .safePadding(WindowInsetsSides.Top)
            .padding(
                horizontal = Theme.spacing.extraMedium,
                vertical = Theme.spacing.small
            )
    ) {
        IconButton(onClick = onGoBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = tint
            )
        }
    }
}