package core.presentation.composables.images

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

actual class GifResource(
    @DrawableRes val id: Int,
)

@Composable
actual fun GifImage(
    url: String,
    modifier: Modifier,
    contentScale: ContentScale,
) {
    AsyncImage(
        model = url,
        contentDescription = null,
        contentScale = contentScale,
        modifier = modifier,
    )
}

@Composable
actual fun GifImage(
    resource: GifResource,
    modifier: Modifier,
    contentScale: ContentScale
) {
    AsyncImage(
        model = resource.id,
        contentDescription = null,
        contentScale = contentScale,
        modifier = modifier,
    )
}