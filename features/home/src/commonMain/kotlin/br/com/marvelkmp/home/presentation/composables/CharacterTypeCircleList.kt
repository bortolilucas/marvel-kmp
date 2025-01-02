package br.com.marvelkmp.home.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.theme.Theme

@Composable
fun CharacterTypeCircleList(
    onCirclePress: (CharacterFilter) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(Theme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = Theme.spacing.large),
        modifier = modifier.fillMaxWidth()
    ) {
        items(CharacterFilter.entries) {
            CharacterTypeCircle(
                type = it,
                onClick = onCirclePress,
            )
        }
    }
}