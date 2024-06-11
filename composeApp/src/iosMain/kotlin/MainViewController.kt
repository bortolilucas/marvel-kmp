import androidx.compose.ui.window.ComposeUIViewController
import br.com.marvelkmp.logging.util.initNapier
import navigation.screenRegistry

fun MainViewController() = ComposeUIViewController(
    configure = {
        initNapier()
        screenRegistry()
    }
) {
    App()
}