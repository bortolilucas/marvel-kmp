package br.com.marvelkmp.core.presentation.composables.images

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import br.com.marvelkmp.core.presentation.util.functions.rememberAsync
import org.jetbrains.compose.animatedimage.animate
import org.jetbrains.compose.animatedimage.loadResourceAnimatedImage

actual class GifResource(
    val name: String,
)

@Composable
actual fun GifImage(
    resource: GifResource,
    modifier: Modifier,
    contentScale: ContentScale
) {
    val gif = rememberAsync { loadResourceAnimatedImage(resource.name) }

    gif?.let {
        Image(
            bitmap = it.animate(),
            contentDescription = null,
            contentScale = contentScale,
            modifier = modifier
        )
    }
}