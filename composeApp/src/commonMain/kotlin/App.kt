import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import core.theme.ui.ThemeProvider
import features.home.ui.screens.home.HomeScreen

@Composable
fun App() {
    ThemeProvider {
        Navigator(HomeScreen)
    }
}
