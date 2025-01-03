package br.com.marvelkmp.core.presentation.composables.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.theme.Theme
import marvelkmp.core.generated.resources.Res
import marvelkmp.core.generated.resources.see_all
import org.jetbrains.compose.resources.stringResource

@Composable
fun <T> HorizontalList(
    title: String,
    data: List<T>,
    keyExtractor: (T) -> Any,
    renderItem: @Composable LazyItemScope.(T) -> Unit,
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = Theme.spacing.large,
    itemSpacing: Dp = Theme.spacing.extraMedium,
    titleColor: Color = Theme.colors.onBackground,
    onSeeAll: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Theme.spacing.extraMedium)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding + Theme.spacing.extraSmall),
        ) {
            Text(
                text = title,
                style = Theme.typography.h4,
                color = titleColor,
            )

            onSeeAll?.let {
                Text(
                    text = stringResource(Res.string.see_all),
                    style = Theme.typography.body1,
                    color = Theme.colors.secondary,
                    modifier = Modifier.clickable(onClick = it)
                )
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = horizontalPadding),
            horizontalArrangement = Arrangement.spacedBy(itemSpacing),
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(data, keyExtractor) {
                Box(modifier = Modifier.width(150.dp)) {
                    renderItem(it)
                }
            }
        }
    }
}