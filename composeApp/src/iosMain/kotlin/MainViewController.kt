import androidx.compose.ui.window.ComposeUIViewController
import logging.util.initNapier

fun MainViewController() = ComposeUIViewController(
    configure = {
        initNapier()
    }
) {
    App()
}