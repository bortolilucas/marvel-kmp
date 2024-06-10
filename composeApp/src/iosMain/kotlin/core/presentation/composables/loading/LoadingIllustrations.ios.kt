package core.presentation.composables.loading

import androidx.compose.ui.unit.dp
import core.presentation.composables.images.GifResource

actual val loadingIllustrations: List<LoadingIllustration> = listOf(
    LoadingIllustration(resource = GifResource(name = "storm")),
    LoadingIllustration(resource = GifResource(name = "wolverine_claws")),
    LoadingIllustration(resource = GifResource(name = "wolverine_walk")),
    LoadingIllustration(resource = GifResource(name = "venom")),
    LoadingIllustration(resource = GifResource(name = "captain_america"), size = 200.dp),
    LoadingIllustration(resource = GifResource(name = "iron_man"), size = 240.dp),
    LoadingIllustration(resource = GifResource(name = "gambit")),
)