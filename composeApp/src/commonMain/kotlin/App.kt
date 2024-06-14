import androidx.compose.runtime.Composable
import br.com.marvelkmp.core.presentation.theme.ThemeProvider
import br.com.marvelkmp.core.presentation.util.dimensions.DimensionsProvider
import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.navigation.utils.getScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

@Composable
fun App() {
    val initialScreen = getScreenRegistry(SharedScreen.Splash)

    DimensionsProvider {
        ThemeProvider {
            Navigator(initialScreen) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}