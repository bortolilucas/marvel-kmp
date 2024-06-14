package br.com.marvelkmp.core.presentation.mapper

import androidx.compose.runtime.Composable
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import marvelkmp.core.generated.resources.Res
import marvelkmp.core.generated.resources.aliens
import marvelkmp.core.generated.resources.antiheroes
import marvelkmp.core.generated.resources.heroes
import marvelkmp.core.generated.resources.humans
import marvelkmp.core.generated.resources.villains
import org.jetbrains.compose.resources.stringResource

@Composable
fun CharacterFilter.asString(): String = when (this) {
    CharacterFilter.HUMAN -> stringResource(Res.string.humans)
    CharacterFilter.HERO -> stringResource(Res.string.heroes)
    CharacterFilter.VILLAIN -> stringResource(Res.string.villains)
    CharacterFilter.ANTIHERO -> stringResource(Res.string.antiheroes)
    CharacterFilter.ALIEN -> stringResource(Res.string.aliens)
}
