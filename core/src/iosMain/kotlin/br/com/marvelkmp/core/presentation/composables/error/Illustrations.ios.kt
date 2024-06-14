package br.com.marvelkmp.core.presentation.composables.error

import br.com.marvelkmp.core.presentation.composables.images.GifResource
import marvelkmp.core.generated.resources.Res
import marvelkmp.core.generated.resources.error_broke_something
import marvelkmp.core.generated.resources.error_captain_america
import marvelkmp.core.generated.resources.error_captain_marvel
import marvelkmp.core.generated.resources.error_hydra_attacking
import marvelkmp.core.generated.resources.error_hydra_stole_the_app
import marvelkmp.core.generated.resources.error_ironman
import marvelkmp.core.generated.resources.error_not_worthy
import marvelkmp.core.generated.resources.error_protocol_missing
import marvelkmp.core.generated.resources.error_thor

actual val illustrations: List<IllustrationVariant> = listOf(
    IllustrationVariant(
        resource = Res.drawable.error_ironman,
        description = Res.string.error_protocol_missing,
        gifResource = GifResource(name = "rain")
    ),
    IllustrationVariant(
        resource = Res.drawable.error_thor,
        description = Res.string.error_not_worthy,
    ),
    IllustrationVariant(
        resource = Res.drawable.error_captain_america,
        description = Res.string.error_hydra_attacking,
    ),
    IllustrationVariant(
        gifResource = GifResource(name = "error_deadpool"),
        description = Res.string.error_broke_something,
    ),
    IllustrationVariant(
        resource = Res.drawable.error_captain_marvel,
        description = Res.string.error_hydra_stole_the_app,
    ),
)