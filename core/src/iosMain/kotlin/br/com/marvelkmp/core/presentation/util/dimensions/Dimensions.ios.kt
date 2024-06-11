package br.com.marvelkmp.core.presentation.util.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getDimensions(): Dimensions {
    val density = LocalDensity.current
    val size = LocalWindowInfo.current.containerSize

    return Dimensions(
        screenWidth = with(density) { size.width.toDp() },
        screenHeight = with(density) { size.height.toDp() }
    )
}