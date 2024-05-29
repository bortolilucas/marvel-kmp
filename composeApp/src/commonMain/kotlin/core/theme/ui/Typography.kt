package core.theme.ui

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.gilroy_black
import marvelkmp.composeapp.generated.resources.gilroy_bold
import marvelkmp.composeapp.generated.resources.gilroy_medium
import marvelkmp.composeapp.generated.resources.gilroy_regular
import marvelkmp.composeapp.generated.resources.gilroy_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun getGilroyFontFamily() = FontFamily(
    Font(Res.font.gilroy_black, FontWeight.Black),
    Font(Res.font.gilroy_bold, FontWeight.Bold),
    Font(Res.font.gilroy_semibold, FontWeight.SemiBold),
    Font(Res.font.gilroy_medium, FontWeight.Medium),
    Font(Res.font.gilroy_regular, FontWeight.Normal),
)

@Composable
fun getTypography() = Typography().run {
    val gilroyFontFamily = getGilroyFontFamily()

    copy(
        h1 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 40.sp,
        ),
        h2 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
        ),
        h3 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
        ),
        h4 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        subtitle1 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        ),
        subtitle2 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        ),
        body1 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        ),
        body2 = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
        ),
        caption = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        ),
        overline = TextStyle(
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
        ),
    )
}