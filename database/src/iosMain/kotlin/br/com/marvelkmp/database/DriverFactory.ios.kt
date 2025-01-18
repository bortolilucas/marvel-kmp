package br.com.marvelkmp.database

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import co.touchlab.sqliter.DatabaseConfiguration

actual class DriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            MarvelDatabase.Schema.synchronous(),
            MARVEL_DATABASE_NAME,
            onConfiguration = { config: DatabaseConfiguration ->
                config.copy(
                    extendedConfig = DatabaseConfiguration.Extended(foreignKeyConstraints = true)
                )
            }
        )
    }
}