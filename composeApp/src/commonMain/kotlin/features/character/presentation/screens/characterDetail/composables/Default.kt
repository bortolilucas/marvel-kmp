package features.character.presentation.screens.characterDetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.age
import marvelkmp.composeapp.generated.resources.height
import marvelkmp.composeapp.generated.resources.universe
import marvelkmp.composeapp.generated.resources.weight

@Composable
fun Default(onBack: () -> Unit) {
    Column(
        Modifier
            .background(Theme.colors.surface)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
                model = "https://i.annihil.us/u/prod/marvel/i/mg/a/f0/5202887448860.jpg",
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
                    text = "Adam Warlock",
                    style = Theme.typography.subtitle1,
                    color = Theme.colors.onSurface
                )
                Text(
                    text = "Adam Warlock",
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
                        icon = Res.drawable.age,
                        text = "1000 years"
                    )
                    CharacterInfo(
                        icon = Res.drawable.weight,
                        text = "108kg"
                    )
                    CharacterInfo(
                        icon = Res.drawable.height,
                        text = "1.83m"
                    )
                    CharacterInfo(
                        icon = Res.drawable.universe,
                        text = "Earth 616"
                    )
                }
                Text(
                    modifier = Modifier.padding(
                        bottom = 32.dp
                    ),
                    text = "Adam Warlock is an artificially created human who was born in a cocoon at a scientific complex called The Beehive.",
                    style = Theme.typography.body1,
                    color = Theme.colors.onSurface
                )
                Text(
                    modifier = Modifier.padding(
                        bottom = 24.dp
                    ),
                    text = "Habilities",
                    style = Theme.typography.h4,
                    color = Theme.colors.onSurface
                )
                Column(
                    modifier = Modifier.padding(bottom = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    HabilityRow(label = "Force", level = 90)
                    HabilityRow(label = "Intelligence", level = 80)
                    HabilityRow(label = "Agility", level = 70)
                    HabilityRow(label = "Resistance", level = 60)
                    HabilityRow(label = "Velocity", level = 50)
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