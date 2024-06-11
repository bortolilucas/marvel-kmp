package br.com.marvelkmp.core.presentation.composables.loading

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.composables.images.GifResource

data class LoadingIllustration(
    val resource: GifResource,
    val size: Dp = 180.dp,
)

expect val loadingIllustrations: List<LoadingIllustration>