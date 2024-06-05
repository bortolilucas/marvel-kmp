package core.presentation.composables.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.presentation.composables.images.GifImage
import core.presentation.theme.Theme
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
        onBack?.let {
            IconButton(modifier = Modifier.padding(12.dp), onClick = it) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Theme.colors.primary
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                Theme.spacing.large,
                Alignment.CenterVertically
            ),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
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
