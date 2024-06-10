package di

import core.presentation.util.gif.GifHelper
import org.koin.dsl.module

fun initKoinIOS(
    gifHelper: GifHelper,
) {
    val depsFromNative = module {
        single<GifHelper> { gifHelper }
    }

    initKoin(listOf(depsFromNative))
}