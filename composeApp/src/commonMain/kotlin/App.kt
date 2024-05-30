import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import core.theme.ui.ThemeProvider

class App : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { TestScreenModel() }

        ThemeProvider {
            Text("Hello World")
            Button(onClick = { screenModel.test() }) {
                Text("Click me")
            }
        }
    }
}