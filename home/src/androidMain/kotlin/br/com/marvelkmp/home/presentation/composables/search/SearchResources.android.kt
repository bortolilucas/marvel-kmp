package br.com.marvelkmp.home.presentation.composables.search

import br.com.marvelkmp.core.presentation.composables.images.GifResource
import br.com.marvelkmp.home.R

actual val searchResources: SearchResources = SearchResources(
    notFoundResource = GifResource(id = R.drawable.spider_man),
    typeToSearchResource = GifResource(id = R.drawable.command_center)
)
