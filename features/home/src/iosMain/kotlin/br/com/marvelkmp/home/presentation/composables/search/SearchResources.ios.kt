package br.com.marvelkmp.home.presentation.composables.search

import br.com.marvelkmp.core.presentation.composables.images.GifResource

actual val searchResources: SearchResources = SearchResources(
    notFoundResource = GifResource(name = "spider_man"),
    typeToSearchResource = GifResource(name = "command_center")
)