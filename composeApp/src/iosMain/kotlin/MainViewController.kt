import androidx.compose.ui.window.ComposeUIViewController
import di.initKoin
import logging.util.initNapier

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
        initNapier()
    }
) {
    App()
}