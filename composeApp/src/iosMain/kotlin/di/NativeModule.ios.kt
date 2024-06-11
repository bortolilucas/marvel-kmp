package di

import br.com.marvelkmp.database.Database
import br.com.marvelkmp.database.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single { DriverFactory() }
    single { Database(get()) }
}