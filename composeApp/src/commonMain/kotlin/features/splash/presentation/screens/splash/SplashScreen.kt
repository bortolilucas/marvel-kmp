package features.splash.presentation.screens.splash

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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import core.presentation.composables.statusbar.StatusBarEffect
import core.presentation.theme.MarvelRed
import core.presentation.theme.PrimaryWhite
import features.home.presentation.screens.home.HomeScreen
import kotlinx.coroutines.delay
import marvelkmp.composeapp.generated.resources.Res
import marvelkmp.composeapp.generated.resources.marvel_logo
import org.jetbrains.compose.resources.painterResource

object SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        StatusBarEffect(isAppearanceLight = false)

        LaunchedEffect(key1 = Unit) {
            delay(3000)
            navigator.replace(HomeScreen)
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