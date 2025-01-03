import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator

@Composable
actual fun NavigatorTransition(navigator: Navigator) =
    CurrentScreen()