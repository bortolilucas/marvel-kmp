package br.com.marvelkmp.core.presentation.composables.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.theme.Theme

@Composable
fun rememberHorizontalItemWidth(
    numOfItems: Int,
    horizontalPadding: Dp,
    itemSpacing: Dp
): Dp {
    val screenWidth = Theme.dimensions.screenWidth

    return remember(screenWidth, numOfItems, horizontalPadding, itemSpacing) {
        val listWidth = screenWidth - horizontalPadding
        val spacingWidth = itemSpacing * (numOfItems - 1)
        val numOfItemsRatio = numOfItems * 0.8
        val itemWidth = (listWidth - spacingWidth) / numOfItemsRatio.dp

        itemWidth.dp
    }
}