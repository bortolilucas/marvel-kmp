package br.com.marvelkmp.home.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.composables.character.CharacterListItem
import br.com.marvelkmp.core.presentation.composables.list.HorizontalList
import br.com.marvelkmp.core.presentation.mapper.asString
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.theme.Theme
import br.com.marvelkmp.home.presentation.model.HomeState
import marvelkmp.home.generated.resources.Res
import marvelkmp.home.generated.resources.pick_character
import marvelkmp.home.generated.resources.welcome
import org.jetbrains.compose.resources.stringResource

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
                    text = stringResource(Res.string.welcome),
                    style = Theme.typography.subtitle2,
                    color = Theme.colors.secondary,
                )
                Text(
                    text = stringResource(Res.string.pick_character),
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