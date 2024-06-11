import androidx.compose.runtime.Composable
import br.com.marvelkmp.core.presentation.theme.ThemeProvider
import br.com.marvelkmp.core.presentation.util.dimensions.DimensionsProvider
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import features.splash.presentation.screens.splash.SplashScreen

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