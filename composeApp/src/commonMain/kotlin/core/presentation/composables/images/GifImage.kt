package core.presentation.composables.images

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

expect class GifResource

@Composable
expect fun GifImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillBounds,
)

@Composable
expect fun GifImage(
    resource: GifResource,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillBounds,
)