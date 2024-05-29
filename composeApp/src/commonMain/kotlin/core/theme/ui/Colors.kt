package core.theme.ui

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val PrimaryRed = Color(0xFFF2264b)
val PrimaryBlack = Color(0xFF000000)
val PrimaryDark = Color(0xFF313140)
val PrimaryGrey = Color(0xB7B7C8)
val PrimarySilver = Color(0xFFF8F8F8)
val PrimaryWhite = Color(0xFFFFFFFF)

val GradientBlue = listOf(Color(0xFF005BEA), Color(0xFF00C6FB))
val GradientRed = listOf(Color(0xFFED1D24), Color(0xFFED1F69))
val GradientPurple = listOf(Color(0xFFB224EF), Color(0xFF7579FF))
val GradientGreen = listOf(Color(0xFF0BA360), Color(0xFF3CBA92))
val GradientPink = listOf(Color(0xFFFF7EB3), Color(0xFFFF758C))
val GradientBlack = listOf(Color(0xFF0000004D), Color(0xFF000000BF))
val GradientDark = listOf(Color(0xFF00000066), Color(0xFF000000))

val lightColors = lightColors(
    primary = PrimaryRed,
    secondary = PrimaryGrey,
    background = PrimarySilver,
    onBackground = PrimaryDark,
    surface = PrimaryBlack,
    onSurface = PrimaryWhite,
)

val darkColors = darkColors(
    primary = PrimaryRed,
    secondary = PrimaryWhite,
    background = PrimaryBlack,
    onBackground = PrimaryWhite,
    surface = PrimaryBlack,
    onSurface = PrimaryWhite,
)