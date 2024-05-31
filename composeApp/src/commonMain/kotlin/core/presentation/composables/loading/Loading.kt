package core.presentation.composables.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Loading() {
    val illustration = loadingIllustrations.random()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        AsyncImage(
            model = illustration.url,
            contentDescription = "Loading...",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(illustration.size)
        )
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}
