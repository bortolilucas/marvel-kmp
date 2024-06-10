package core.presentation.composables.loading

import androidx.compose.ui.unit.dp
import br.com.marvelkmp.app.R
import core.presentation.composables.images.GifResource

actual val loadingIllustrations: List<LoadingIllustration> = listOf(
    LoadingIllustration(resource = GifResource(id = R.drawable.storm)),
    LoadingIllustration(resource = GifResource(id = R.drawable.wolverine_walk)),
    LoadingIllustration(resource = GifResource(id = R.drawable.wolverine_claws)),
    LoadingIllustration(resource = GifResource(id = R.drawable.venom)),
    LoadingIllustration(resource = GifResource(id = R.drawable.captain_america), size = 200.dp),
    LoadingIllustration(resource = GifResource(id = R.drawable.iron_man), size = 240.dp),
    LoadingIllustration(resource = GifResource(id = R.drawable.gambit)),
)