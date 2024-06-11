package br.com.marvelkmp.core.presentation.composables.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.composables.statusbar.StatusBarEffect
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.modifiers.safePadding
import marvelkmp.core.generated.resources.Res
import marvelkmp.core.generated.resources.heart
import marvelkmp.core.generated.resources.marvel_logo
import marvelkmp.core.generated.resources.search
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header(
    onMenuClick: () -> Unit,
    onSearchClick: () -> Unit,
    isSearchVisible: Boolean = false
) {
    StatusBarEffect()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .safePadding(WindowInsetsSides.Top)
            .padding(
                vertical = Theme.spacing.small,
                horizontal = Theme.spacing.extraMedium,
            )
    ) {
        IconButton(onClick = onSearchClick) {
            if (isSearchVisible) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier.size(24.dp),
                    tint = Theme.colors.onBackground
                )

                return@IconButton
            }

            Icon(
                painter = painterResource(Res.drawable.search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp),
                tint = Theme.colors.onBackground
            )
        }
        Icon(
            painter = painterResource(Res.drawable.marvel_logo),
            contentDescription = "Marvel Logo",
            modifier = Modifier.width(70.dp),
            tint = Theme.colors.primary
        )
        IconButton(onClick = onMenuClick) {
            Icon(
                painter = painterResource(Res.drawable.heart),
                contentDescription = "Menu",
                modifier = Modifier.size(24.dp),
                tint = Theme.colors.onBackground
            )
        }
    }
}