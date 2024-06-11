package features.home.presentation.composables.search

import br.com.marvelkmp.app.R
import br.com.marvelkmp.core.presentation.composables.images.GifResource

actual val searchResources: SearchResources = SearchResources(
    notFoundResource = GifResource(id = R.drawable.spider_man),
    typeToSearchResource = GifResource(id = R.drawable.command_center)
)