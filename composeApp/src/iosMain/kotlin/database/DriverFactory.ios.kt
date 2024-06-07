package database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import br.com.marvelkmp.app.MarvelDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MarvelDatabase.Schema, "MarvelDatabase.db")
    }
}