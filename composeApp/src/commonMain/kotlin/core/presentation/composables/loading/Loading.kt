package core.presentation.composables.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import coil3.compose.AsyncImage
import core.presentation.theme.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Loading(
    loadingTextColor: Color = Theme.colors.onBackground
) {
    val illustration = loadingIllustrations.random()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            Theme.spacing.large,
            Alignment.CenterVertically
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = Theme.spacing.extraBig),
    ) {
        AsyncImage(
            model = illustration.url,
            contentDescription = "Loading...",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(illustration.size)
        )

        Text(
            text = "Loading...",
            style = Theme.typography.h3,
            color = loadingTextColor,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}
