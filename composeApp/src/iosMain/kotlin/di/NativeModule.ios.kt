package di

import database.Database
import database.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single { DriverFactory() }
    single { Database(get()) }
}