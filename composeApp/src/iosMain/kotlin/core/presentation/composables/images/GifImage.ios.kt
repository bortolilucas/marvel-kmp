package core.presentation.composables.images

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.layout.ContentScale
import core.presentation.mapper.toUIColor
import core.presentation.theme.Theme
import core.presentation.util.gif.gifImageWithURL
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.launch
import platform.UIKit.UIImageView
import platform.UIKit.UIViewContentMode

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GifImage(
    url: String,
    modifier: Modifier,
    contentScale: ContentScale,
) {
    val backgroundColor = Theme.colors.background
    val scope = rememberCoroutineScope()

    val imageView = remember(url) {
        UIImageView().apply {
            scope.launch {
                this@apply.image = gifImageWithURL(url)
            }

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