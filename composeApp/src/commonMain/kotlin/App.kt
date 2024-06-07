import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import core.presentation.theme.ThemeProvider
import core.presentation.util.dimensions.DimensionsProvider
import features.splash.presentation.screens.splash.SplashScreen
import org.koin.core.module.Module

@Composable
fun App() {
    DimensionsProvider {
        ThemeProvider {
            Navigator(SplashScreen) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}

expect val appModule: Module