package br.com.marvelkmp.home.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.mapper.asString
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.theme.GradientBlue
import br.com.marvelkmp.core.presentation.theme.GradientGreen
import br.com.marvelkmp.core.presentation.theme.GradientPink
import br.com.marvelkmp.core.presentation.theme.GradientPurple
import br.com.marvelkmp.core.presentation.theme.GradientRed
import br.com.marvelkmp.core.presentation.theme.PrimaryWhite
import br.com.marvelkmp.core.presentation.theme.Theme
import marvelkmp.features.home.generated.resources.Res
import marvelkmp.features.home.generated.resources.alien_icon
import marvelkmp.features.home.generated.resources.antihero_icon
import marvelkmp.features.home.generated.resources.hero_icon
import marvelkmp.features.home.generated.resources.human_icon
import marvelkmp.features.home.generated.resources.villain_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun CharacterTypeCircle(
    type: CharacterFilter,
    onClick: (CharacterFilter) -> Unit,
    modifier: Modifier = Modifier,
) {
    val (icon, colors) = when (type) {
        CharacterFilter.HERO -> Pair(Res.drawable.hero_icon, GradientBlue)
        CharacterFilter.VILLAIN -> Pair(Res.drawable.villain_icon, GradientRed)
        CharacterFilter.ANTIHERO -> Pair(Res.drawable.antihero_icon, GradientPurple)
        CharacterFilter.HUMAN -> Pair(Res.drawable.human_icon, GradientGreen)
        CharacterFilter.ALIEN -> Pair(Res.drawable.alien_icon, GradientPink)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .width(60.dp)
            .aspectRatio(1f)
            .shadow(Theme.spacing.small, Theme.shapes.large)
            .background(Brush.horizontalGradient(colors))
            .clickable { onClick(type) }
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = type.asString(),
            tint = PrimaryWhite,
            modifier = Modifier.size(32.dp)
        )
    }
}