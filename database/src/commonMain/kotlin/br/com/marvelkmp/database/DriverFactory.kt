package br.com.marvelkmp.database

import app.cash.sqldelight.db.SqlDriver

internal const val MARVEL_DATABASE_NAME = "MarvelDatabase.db"

expect class DriverFactory {
    fun createDriver(): SqlDriver
}