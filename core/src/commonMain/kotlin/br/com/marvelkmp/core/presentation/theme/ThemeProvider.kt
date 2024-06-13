package br.com.marvelkmp.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ThemeProvider(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (isDarkTheme) darkColors else lightColors

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalDimensions provides getDimensions()
    ) {
        MaterialTheme(
            colors = colors,
            shapes = shapes,
            typography = getTypography(),
            content = content
        )
    }
}