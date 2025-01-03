package br.com.marvelkmp.core.presentation.composables.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.composables.images.GifImage
import br.com.marvelkmp.core.presentation.composables.navigation.GoBackHeader
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.modifiers.safePadding
import marvelkmp.core.generated.resources.Res
import marvelkmp.core.generated.resources.error_generic
import marvelkmp.core.generated.resources.try_again
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
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
                    randomIllustration.gifResource?.let {
                        GifImage(
                            modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                            contentScale = ContentScale.FillBounds,
                            resource = it,
                        )
                    }
                    randomIllustration.resource?.let {
                        Image(
                            modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                            painter = painterResource(it),
                            contentDescription = stringResource(randomIllustration.description),
                            contentScale = ContentScale.Fit,
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(Res.string.error_generic),
                    style = Theme.typography.h3,
                    color = Theme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(randomIllustration.description),
                    style = Theme.typography.h4,
                    color = Theme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
            }
            Button(
                modifier =
                    Modifier
                        .widthIn(Theme.dimensions.screenWidth, 500.dp)
                        .height(50.dp),
                onClick = { onRetry() }
            ) {
                Text(
                    text = stringResource(Res.string.try_again),
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