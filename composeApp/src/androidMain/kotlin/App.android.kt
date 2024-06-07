import database.Database
import database.DriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


actual val appModule: Module = module {
    single { DriverFactory(this.androidContext()) }
    single { Database(get()) }
}