package core.presentation.composables.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.presentation.composables.images.GifImage
import core.presentation.composables.navigation.GoBackHeader
import core.presentation.theme.Theme
import core.presentation.util.modifiers.safePadding
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ErrorContainer(onBack: (() -> Unit)? = null, onRetry: () -> Unit) {
    val randomIllustration = remember { illustrations.random() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.background)
            .padding(bottom = Theme.spacing.small)
    ) {
        onBack?.let { GoBackHeader(onGoBack = it) }

        Column(
            Modifier
                .safePadding(WindowInsetsSides.Bottom)
                .padding(Theme.spacing.extraMedium)
        ) {

            Column(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(horizontal = Theme.spacing.extraMedium)
                    .padding(bottom = Theme.spacing.extraBig),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box {
                    GifImage(
                        modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                        url = randomIllustration.url,
                        contentScale = ContentScale.Fit,
                    )
                    if (randomIllustration.secondUrl.isNotEmpty())
                        GifImage(
                            modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                            contentScale = ContentScale.FillBounds,
                            url = randomIllustration.secondUrl,
                        )
                }
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "An error occoured when load the data",
                    style = Theme.typography.h3,
                    color = Theme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
                Text(
                    randomIllustration.description,
                    style = Theme.typography.h4,
                    color = Theme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
            }
            Button(modifier = Modifier.fillMaxWidth().height(50.dp), onClick = { onRetry() }) {
                Text(
                    "Try again",
                    style = Theme.typography.h4,
                    color = Theme.colors.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
private fun ErrorPreview() {
    ErrorContainer(onBack = {}, onRetry = {})
}