package br.com.marvelkmp.core.presentation.composables.loading

import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.composables.images.GifResource

actual val loadingIllustrations: List<LoadingIllustration> = listOf(
    LoadingIllustration(resource = GifResource(name = "storm.gif")),
    LoadingIllustration(resource = GifResource(name = "wolverine_claws.gif")),
    LoadingIllustration(resource = GifResource(name = "wolverine_walk.gif")),
    LoadingIllustration(resource = GifResource(name = "venom.gif")),
    LoadingIllustration(resource = GifResource(name = "captain_america.gif"), size = 200.dp),
    LoadingIllustration(resource = GifResource(name = "iron_man.gif"), size = 240.dp),
    LoadingIllustration(resource = GifResource(name = "gambit.gif")),
)