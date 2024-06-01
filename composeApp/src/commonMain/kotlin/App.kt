import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import core.presentation.theme.ThemeProvider
import core.presentation.util.dimensions.DimensionsProvider
import features.home.presentation.screens.home.HomeScreen

@Composable
fun App() {
    DimensionsProvider {
        ThemeProvider {
            Navigator(HomeScreen)
        }
    }
}
