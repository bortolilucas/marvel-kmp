package br.com.marvelkmp.core.presentation.util.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
actual fun getDimensions(): Dimensions {
    val configuration = LocalConfiguration.current

    return Dimensions(
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}