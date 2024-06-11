package br.com.marvelkmp.core.presentation.composables.statusbar

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
expect fun StatusBarEffect(
    isAppearanceLight: Boolean = !isSystemInDarkTheme(),
)