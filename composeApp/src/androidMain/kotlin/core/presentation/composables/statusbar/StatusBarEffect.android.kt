package core.presentation.composables.statusbar

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
actual fun StatusBarEffect(isAppearanceLight: Boolean) {
    val view = LocalView.current
    val isDarkTheme = isSystemInDarkTheme()

    DisposableEffect(key1 = Unit) {
        val window = (view.context as Activity).window

        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
            isAppearanceLight

        onDispose {
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                !isDarkTheme
        }
    }
}