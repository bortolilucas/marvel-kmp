import androidx.compose.ui.window.ComposeUIViewController
import br.com.marvelkmp.logging.util.initNapier

fun MainViewController() = ComposeUIViewController(
    configure = {
        initNapier()
        screenRegistry()
    }
) {
    App()
}