package br.com.marvelkmp.splash.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.presentation.composables.statusbar.StatusBarEffect
import br.com.marvelkmp.core.presentation.theme.MarvelRed
import br.com.marvelkmp.core.presentation.theme.PrimaryWhite
import br.com.marvelkmp.navigation.SharedScreen
import br.com.marvelkmp.navigation.utils.getScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import marvelkmp.features.splash.generated.resources.Res
import marvelkmp.features.splash.generated.resources.marvel_logo
import org.jetbrains.compose.resources.painterResource

object SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        StatusBarEffect(isAppearanceLight = false)

        LaunchedEffect(key1 = Unit) {
            delay(3000)
            navigator.replace(getScreenRegistry(SharedScreen.Home))
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MarvelRed)
        ) {
            Icon(
                painter = painterResource(Res.drawable.marvel_logo),
                contentDescription = "Marvel",
                tint = PrimaryWhite,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}