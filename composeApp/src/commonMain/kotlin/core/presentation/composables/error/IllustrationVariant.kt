package core.presentation.composables.error

import core.presentation.composables.images.GifResource
import org.jetbrains.compose.resources.DrawableResource

data class IllustrationVariant(
    val resource: DrawableResource? = null,
    val gifResource: GifResource? = null,
    val description: String,
)