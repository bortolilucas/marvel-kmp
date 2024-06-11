package br.com.marvelkmp.core.presentation.composables.images

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.layout.ContentScale
import br.com.marvelkmp.core.presentation.mapper.toUIColor
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.gif.GifHelper
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.compose.koinInject
import platform.UIKit.UIViewContentMode

actual class GifResource(
    val name: String,
)

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GifImage(
    url: String,
    modifier: Modifier,
    contentScale: ContentScale,
) {
    val gifHelper = koinInject<GifHelper>()
    val backgroundColor = Theme.colors.background

    val imageView = remember(url) {
        gifHelper.gifImageWithURL(url).apply {
            this.backgroundColor = backgroundColor.toUIColor()
            this.contentMode = when (contentScale) {
                ContentScale.Fit -> UIViewContentMode.UIViewContentModeScaleAspectFit
                else -> UIViewContentMode.UIViewContentModeScaleAspectFill
            }
        }
    }

    UIKitView(
        factory = { imageView },
        modifier = modifier,
    )
}


@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GifImage(
    resource: GifResource,
    modifier: Modifier,
    contentScale: ContentScale
) {
    val gifHelper = koinInject<GifHelper>()
    val backgroundColor = Theme.colors.background

    val imageView = remember(resource) {
        gifHelper.gitImageWithName(resource.name).apply {
            this.backgroundColor = backgroundColor.toUIColor()
            this.contentMode = when (contentScale) {
                ContentScale.Fit -> UIViewContentMode.UIViewContentModeScaleAspectFit
                else -> UIViewContentMode.UIViewContentModeScaleAspectFill
            }
        }
    }

    UIKitView(
        factory = { imageView },
        modifier = modifier,
    )
}