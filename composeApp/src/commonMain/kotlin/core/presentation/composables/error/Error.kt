package core.presentation.composables.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import core.theme.ui.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Error(onBack: () -> Unit, onRetry: () -> Unit) {
    val randomIllustration = illustrations.random()

    Column(
        Modifier.fillMaxSize().background(Theme.colors.onSurface).padding(Theme.spacing.extraMedium)
    ) {
        IconButton(onClick = { onBack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Theme.colors.primary
            )
        }
        Column(
            Modifier.weight(1f).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                AsyncImage(
                    modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                    model = randomIllustration.url,
                    contentDescription = null,
                )
                if (randomIllustration.secondUrl.isNotEmpty())
                    AsyncImage(
                        modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                        contentScale = ContentScale.FillBounds,
                        model = randomIllustration.secondUrl,
                        contentDescription = null,
                    )
            }
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "An error occoured when load the data",
                style = Theme.typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                randomIllustration.description,
                style = Theme.typography.h4,
                textAlign = TextAlign.Center
            )
        }
        Button(modifier = Modifier.fillMaxWidth().height(50.dp), onClick = { onRetry() }) {
            Text("Tentar novamente", style = Theme.typography.h4)
        }
    }
}

@Preview
@Composable
private fun ErrorPreview() {
    Error(onBack = {}, onRetry = {})
}