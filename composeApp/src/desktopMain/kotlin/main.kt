import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.marvelkmp.logging.util.initNapier
import di.initKoin
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.title
import navigation.screenRegistry
import org.jetbrains.compose.resources.stringResource

fun main() = run {
    initKoin()
    initNapier()
    screenRegistry()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = stringResource(Res.string.title),
        ) {
            App()
        }
    }
}