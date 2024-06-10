package features.home.presentation.composables.search

import core.presentation.composables.images.GifResource

actual val searchResources: SearchResources = SearchResources(
    notFoundResource = GifResource(name = "spider_man"),
    typeToSearchResource = GifResource(name = "command_center")
)