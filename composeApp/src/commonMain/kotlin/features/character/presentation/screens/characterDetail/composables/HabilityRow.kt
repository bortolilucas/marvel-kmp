package features.character.presentation.screens.characterDetail.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.presentation.theme.Theme

const val NUM_OF_BARS = 45

@Composable
fun HabilityRow(
    label: String,
    level: Int
) {
    @Composable
    fun getAbilityBarLevel(item: Int): Color {
        val shouldRenderCompletedAbilityBar = item <= (level * NUM_OF_BARS) / 100

        if (shouldRenderCompletedAbilityBar) return Theme.colors.onSurface

        return Theme.colors.onBackground
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.width(70.dp),
            text = label,
            style = Theme.typography.body2,
            color = Theme.colors.onSurface,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            for (i in 1..NUM_OF_BARS) {
                Column(
                    modifier = Modifier
                        .height(10.dp)
                        .width(1.dp)
                        .background(
                            getAbilityBarLevel(item = i)
                        )
                ) {}
            }
        }
    }
}