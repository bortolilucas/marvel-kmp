package features.home.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.presentation.theme.Theme
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.marvel_logo
import marvelkmp.composeapp.generated.resources.menu
import marvelkmp.composeapp.generated.resources.search
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header(
    onMenuClick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Theme.spacing.medium,
                bottom = Theme.spacing.small,
                start = Theme.spacing.extraMedium,
                end = Theme.spacing.extraMedium
            )
    ) {
        IconButton(onClick = onMenuClick) {
            Icon(
                painter = painterResource(Res.drawable.menu),
                contentDescription = "Menu",
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

        IconButton(onClick = onSearchClick) {
            Icon(
                painter = painterResource(Res.drawable.search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp),
                tint = Theme.colors.onBackground
            )
        }
    }
}