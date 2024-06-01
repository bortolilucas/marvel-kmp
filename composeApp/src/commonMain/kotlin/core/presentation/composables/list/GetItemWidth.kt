package core.presentation.composables.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.presentation.util.dimensions.LocalDimensions

@Composable
fun getHorizontalItemWidth(
    numOfItems: Int,
    horizontalPadding: Dp,
    itemSpacing: Dp
): Dp {
    val listWidth = LocalDimensions.current.screenWidth - horizontalPadding
    val spacingWidth = itemSpacing * (numOfItems - 1)
    val numOfItemsRatio = numOfItems * 0.8
    val itemWidth = (listWidth - spacingWidth) / numOfItemsRatio.dp

    return itemWidth.dp
}