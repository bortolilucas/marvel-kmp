import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

@Composable
actual fun NavigatorTransition(navigator: Navigator) =
    SlideTransition(navigator)