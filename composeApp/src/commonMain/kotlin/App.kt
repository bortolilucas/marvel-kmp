import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import core.presentation.theme.ThemeProvider
import features.home.presentation.screens.home.HomeScreen

@Composable
fun App() {
    ThemeProvider {
        Navigator(HomeScreen)
    }
}
