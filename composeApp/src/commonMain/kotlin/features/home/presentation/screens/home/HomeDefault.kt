package features.home.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.presentation.composables.list.HorizontalList
import core.presentation.theme.Theme
import core.domain.model.Character
import features.home.presentation.composables.CharacterListItem

@Composable
fun HomeDefault(
    state: HomeState,
    onCharacterClick: (Character) -> Unit,
) {
    LazyColumn {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.medium),
                modifier = Modifier
                    .padding(
                        start = Theme.spacing.large,
                        end = Theme.spacing.large,
                        top = Theme.spacing.medium,
                        bottom = Theme.spacing.extraLarge,
                    )
            ) {
                Text(
                    text = "Welcome to Marvel Heroes",
                    style = Theme.typography.subtitle2,
                    color = Theme.colors.secondary,
                )
                Text(
                    text = "Pick your\ncharacter",
                    style = Theme.typography.h2,
                    color = Theme.colors.onBackground,
                )
            }
        }

        items(state.sections, key = { it.title }) { section ->
            HorizontalList(
                title = section.title,
                data = section.data,
                keyExtractor = { it.id },
                titleColor = Theme.colors.primary,
                onSeeAll = {},
                renderItem = {
                    CharacterListItem(
                        character = it,
                        onClick = onCharacterClick,
                    )
                },
                modifier = Modifier.padding(
                    bottom = Theme.spacing.big
                )
            )
        }
    }
}