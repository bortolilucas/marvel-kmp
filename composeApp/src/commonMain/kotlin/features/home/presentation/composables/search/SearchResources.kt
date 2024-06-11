package features.home.presentation.composables.search

import br.com.marvelkmp.core.presentation.composables.images.GifResource

class SearchResources(
    val notFoundResource: GifResource,
    val typeToSearchResource: GifResource,
)

expect val searchResources: SearchResources