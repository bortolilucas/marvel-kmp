package core.presentation.composables.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import core.presentation.composables.images.GifImage
import core.presentation.composables.navigation.GoBackHeader
import core.presentation.theme.Theme
import core.presentation.util.modifiers.safePadding
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Loading(
    loadingTextColor: Color = Theme.colors.onBackground,
    onBack: (() -> Unit)? = null,
) {
    val illustration = loadingIllustrations.random()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = Theme.spacing.large),
    ) {
        onBack?.let { GoBackHeader(onGoBack = it) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                Theme.spacing.large,
                Alignment.CenterVertically
            ),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .safePadding(WindowInsetsSides.Bottom)
                .padding(bottom = Theme.spacing.extraBig),
        ) {
            GifImage(
                url = illustration.url,
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
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}
