package br.com.marvelkmp.database

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DriverFactory(private val context: Context) {
    actual suspend fun createDriver(): SqlDriver {
        val schema = MarvelDatabase.Schema.synchronous()

        return AndroidSqliteDriver(
            schema,
            context,
            MARVEL_DATABASE_NAME,
            callback = object : AndroidSqliteDriver.Callback(schema) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    db.setForeignKeyConstraintsEnabled(true)
                }
            }
        )
    }
}