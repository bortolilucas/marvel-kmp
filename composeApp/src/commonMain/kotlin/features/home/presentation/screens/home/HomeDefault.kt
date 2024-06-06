package features.home.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.domain.model.Character
import core.presentation.composables.list.HorizontalList
import core.presentation.mapper.asString
import core.presentation.model.CharacterFilter
import core.presentation.theme.Theme
import features.home.presentation.composables.CharacterListItem
import features.home.presentation.composables.CharacterTypeCircleList

@Composable
fun HomeDefault(
    state: HomeState,
    onCharacterClick: (Character) -> Unit,
    onCharacterTypeClick: (CharacterFilter) -> Unit,
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

                CharacterTypeCircleList(
                    onCirclePress = onCharacterTypeClick,
                    modifier = Modifier.padding(
                        top = Theme.spacing.medium,
                        bottom = Theme.spacing.small
                    )
                )
            }
        }

        items(state.sections, key = { it.type }) { section ->
            HorizontalList(
                title = section.type.asString(),
                data = section.characters,
                keyExtractor = { it.id },
                titleColor = Theme.colors.primary,
                onSeeAll = { onCharacterTypeClick(section.type) },
                renderItem = {
                    CharacterListItem(
                        character = it,
                        onClick = onCharacterClick,
                    )
                },
                modifier = Modifier.padding(bottom = Theme.spacing.extraBig)
            )
        }
    }
}