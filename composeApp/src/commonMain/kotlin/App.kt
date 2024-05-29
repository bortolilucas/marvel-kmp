import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import core.theme.ui.ThemeProvider
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ThemeProvider {
        Text("Hello World")
    }
}