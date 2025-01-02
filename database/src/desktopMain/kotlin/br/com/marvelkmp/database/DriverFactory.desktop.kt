package br.com.marvelkmp.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import java.util.Properties

actual class DriverFactory {
    actual fun createDriver(): SqlDriver =
        JdbcSqliteDriver(
            url = "jdbc:sqlite:$MARVEL_DATABASE_NAME",
            properties = Properties().apply {
                put("foreign_keys", "true")
            }
        )
            .also { MarvelDatabase.Schema.create(it) }
}