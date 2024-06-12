package br.com.marvelkmp.character.presentation.screens.characterDetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.data.model.marvel.CharacterDetails
import br.com.marvelkmp.core.presentation.composables.list.HorizontalList
import br.com.marvelkmp.core.presentation.composables.navigation.GoBackHeader
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.core.presentation.util.modifiers.safePadding
import coil3.compose.AsyncImage
import marvelkmp.character.generated.resources.Res
import marvelkmp.character.generated.resources.gender
import marvelkmp.character.generated.resources.height
import marvelkmp.character.generated.resources.universe
import marvelkmp.character.generated.resources.weight

@Composable
fun CharacterDetailsDefault(
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    character: CharacterDetails,
    isFavorite: Boolean
) {
    Column(
        Modifier
            .background(Theme.colors.surface)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().height(400.dp),
                contentScale = ContentScale.FillWidth,
                model = character.backgroundImage,
                contentDescription = null,
            )
            GoBackHeader(
                tint = Theme.colors.onSurface,
                onGoBack = onBack,
                isStatusAppearanceLight = false,
                showFavoriteButton = true,
                isFavorited = isFavorite,
                onToggleFavorite = { onToggleFavorite() }
            )
            Box(
                Modifier.fillMaxWidth().matchParentSize().background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Theme.colors.surface),
                        startY = 100f
                    )
                ).align(Alignment.BottomCenter)
            )
            Column(
                Modifier.align(Alignment.BottomStart).padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = character.realName,
                    style = Theme.typography.subtitle1,
                    color = Theme.colors.onSurface
                )
                Text(
                    text = character.name,
                    style = Theme.typography.h1,
                    color = Theme.colors.onSurface
                )
            }
        }
        Column(
            modifier = Modifier
                .safePadding(WindowInsetsSides.Bottom)
                .padding(bottom = Theme.spacing.extraMedium)
        ) {
            Column(Modifier.padding(horizontal = 24.dp)) {
                Row(
                    Modifier
                        .padding(
                            top = 48.dp,
                            bottom = 24.dp
                        ).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CharacterInfo(
                        icon = Res.drawable.gender,
                        text = character.gender
                    )
                    CharacterInfo(
                        icon = Res.drawable.weight,
                        text = character.weight
                    )
                    CharacterInfo(
                        icon = Res.drawable.height,
                        text = character.height
                    )
                    CharacterInfo(
                        icon = Res.drawable.universe,
                        text = character.race
                    )
                }
                character.biography?.let {
                    Text(
                        modifier = Modifier.padding(
                            bottom = 32.dp
                        ),
                        text = it,
                        style = Theme.typography.body1,
                        color = Theme.colors.onSurface
                    )
                }
                character.stats?.let {
                    Text(
                        modifier = Modifier.padding(
                            bottom = 24.dp
                        ),
                        text = "Abilities",
                        style = Theme.typography.h4,
                        color = Theme.colors.onSurface
                    )
                    Column(
                        modifier = Modifier.padding(bottom = 32.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        HabilityRow(label = "Power", level = it.power)
                        HabilityRow(label = "Intelligence", level = it.intelligence)
                        HabilityRow(label = "Strength", level = it.strength)
                        HabilityRow(label = "Combat", level = it.combat)
                        HabilityRow(label = "Speed", level = it.speed)
                        HabilityRow(label = "Durability", level = it.durability)
                    }
                }
            }
            character.comics?.let {
                if (it.isNotEmpty()) {
                    HorizontalList(
                        modifier = Modifier.padding(bottom = 24.dp),
                        title = "Comics",
                        titleColor = Theme.colors.onSurface,
                        data = it,
                        horizontalPadding = 24.dp,
                        keyExtractor = { it.id },
                        renderItem = { item ->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .shadow(Theme.spacing.small, Theme.shapes.large)
                                    .background(Theme.colors.onSurface)
                                    .clip(Theme.shapes.large)
                            ) {
                                AsyncImage(
                                    model = item.cover,
                                    contentDescription = null
                                )
                                Box(
                                    Modifier.fillMaxWidth().matchParentSize().background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Transparent,
                                                Theme.colors.surface
                                            ),
                                            startY = 100f
                                        )
                                    ).align(Alignment.BottomCenter)
                                )
                                Text(
                                    modifier = Modifier.align(Alignment.BottomStart).padding(12.dp),
                                    text = item.title,
                                    style = Theme.typography.h3,
                                    color = Theme.colors.onSurface
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}