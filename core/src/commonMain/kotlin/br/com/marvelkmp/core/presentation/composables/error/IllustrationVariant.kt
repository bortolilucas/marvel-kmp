package br.com.marvelkmp.core.presentation.composables.error

import br.com.marvelkmp.core.presentation.composables.images.GifResource
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class IllustrationVariant(
    val resource: DrawableResource? = null,
    val gifResource: GifResource? = null,
    val description: StringResource,
)