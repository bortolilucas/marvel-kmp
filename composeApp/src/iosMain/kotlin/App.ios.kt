import br.com.marvelkmp.app.MarvelDatabase
import database.Database
import database.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val appModule: Module = module {
    single { Database(get()) }
    single { DriverFactory().createDriver() }
}