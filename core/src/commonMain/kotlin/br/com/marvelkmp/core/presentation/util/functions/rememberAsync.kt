package br.com.marvelkmp.core.presentation.util.functions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
inline fun <T> rememberAsync(
    crossinline calculation: @DisallowComposableCalls suspend () -> T
): T? {
    var value by remember { mutableStateOf<T?>(null) }

    LaunchedEffect(Unit) {
        value = calculation()
    }

    return value
}