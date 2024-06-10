package core.presentation.composables.error

import core.presentation.composables.images.GifResource
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.error_captain_america
import marvelkmp.composeapp.generated.resources.error_captain_marvel
import marvelkmp.composeapp.generated.resources.error_ironman
import marvelkmp.composeapp.generated.resources.error_thor

actual val illustrations: List<IllustrationVariant> = listOf(
    IllustrationVariant(
        resource = Res.drawable.error_ironman,
        description = "Protocol missing... Exiting program...",
        gifResource = GifResource(name = "rain")
    ),
    IllustrationVariant(
        resource = Res.drawable.error_thor,
        description = "You are not worthy..."
    ),
    IllustrationVariant(
        resource = Res.drawable.error_captain_america,
        description = "HYDRA is currently attacking this app!"
    ),
    IllustrationVariant(
        gifResource = GifResource(name = "error_deadpool"),
        description = "$#&%, you broke something! Just kidding..."
    ),
    IllustrationVariant(
        resource = Res.drawable.error_captain_marvel,
        description = "HYDRA has stolen this app from the S.H.I.E.L.D. database!"
    ),
)