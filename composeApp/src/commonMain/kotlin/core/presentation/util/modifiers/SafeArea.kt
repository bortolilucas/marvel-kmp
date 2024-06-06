package core.presentation.util.modifiers

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun getBottomSafePadding(): Dp = WindowInsets.safeDrawing
    .only(WindowInsetsSides.Bottom)
    .asPaddingValues()
    .calculateBottomPadding()

@Composable
fun getTopSafePadding(): Dp = WindowInsets.safeDrawing
    .only(WindowInsetsSides.Top)
    .asPaddingValues()
    .calculateTopPadding()

@Composable
fun Modifier.safePadding(
    insetsSides: WindowInsetsSides? = null
): Modifier = when (insetsSides) {
    WindowInsetsSides.Top -> this.padding(top = getTopSafePadding())
    WindowInsetsSides.Bottom -> this.padding(bottom = getBottomSafePadding())
    else -> this.safeDrawingPadding()
}