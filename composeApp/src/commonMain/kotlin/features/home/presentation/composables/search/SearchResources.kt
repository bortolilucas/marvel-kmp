package features.home.presentation.composables.search

import core.presentation.composables.images.GifResource

class SearchResources(
    val notFoundResource: GifResource,
    val typeToSearchResource: GifResource,
)

expect val searchResources: SearchResources