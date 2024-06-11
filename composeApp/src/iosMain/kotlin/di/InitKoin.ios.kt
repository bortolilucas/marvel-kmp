package di

import br.com.marvelkmp.core.presentation.util.gif.GifHelper
import org.koin.dsl.module

fun initKoinIOS(
    gifHelper: GifHelper,
) {
    val depsFromNative = module {
        single<GifHelper> { gifHelper }
    }

    initKoin(listOf(depsFromNative))
}