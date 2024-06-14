package br.com.marvelkmp.core.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp

@Stable
data class Dimensions(
    val screenWidth: Dp,
    val screenHeight: Dp
)

@Composable
expect fun getDimensions(): Dimensions

val LocalDimensions = compositionLocalOf {
    Dimensions(
        screenWidth = Dp.Unspecified,
        screenHeight = Dp.Unspecified,
    )
}