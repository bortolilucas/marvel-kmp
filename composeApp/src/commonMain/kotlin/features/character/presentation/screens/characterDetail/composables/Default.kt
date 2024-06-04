package features.character.presentation.screens.characterDetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import core.presentation.composables.list.HorizontalList
import core.presentation.theme.Theme
import features.character.data.model.CharacterDetails
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.age
import marvelkmp.composeapp.generated.resources.gender
import marvelkmp.composeapp.generated.resources.height
import marvelkmp.composeapp.generated.resources.universe
import marvelkmp.composeapp.generated.resources.weight

@Composable
fun CharacterDetailsDefault(onBack: () -> Unit, character: CharacterDetails) {
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
            Row(Modifier.padding(horizontal = 12.dp, vertical = 20.dp)) {
                IconButton(onClick = { onBack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Theme.colors.onSurface
                    )
                }
            }
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
        Column {
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
                if (character.biography != null) {
                    Text(
                        modifier = Modifier.padding(
                            bottom = 32.dp
                        ),
                        text = character.biography,
                        style = Theme.typography.body1,
                        color = Theme.colors.onSurface
                    )
                }
                if (character.stats != null) {
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
                        HabilityRow(label = "Power", level = character.stats.power)
                        HabilityRow(label = "Intelligence", level = character.stats.intelligence)
                        HabilityRow(label = "Strength", level = character.stats.strength)
                        HabilityRow(label = "Combat", level = character.stats.combat)
                        HabilityRow(label = "Speed", level = character.stats.speed)
                        HabilityRow(label = "Durability", level = character.stats.durability)
                    }
                }
            }
            HorizontalList(
                title = "Comics",
                titleColor = Theme.colors.onSurface,
                data = listOf("Guardians of the Galaxy", "Infinity Gauntlet", "Infinity War"),
                onSeeAll = {},
                horizontalPadding = 24.dp,
                keyExtractor = { it },
                renderItem = { item ->
                    AsyncImage(
                        model = "https://i.annihil.us/u/prod/marvel/i/mg/c/50/64e3c09ade63c.jpg",
                        contentDescription = null
                    )
                }
            )
        }
    }
}