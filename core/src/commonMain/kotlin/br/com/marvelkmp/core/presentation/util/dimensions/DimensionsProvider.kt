package br.com.marvelkmp.core.presentation.util.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun DimensionsProvider(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalDimensions provides getDimensions(),
        content = content
    )
}