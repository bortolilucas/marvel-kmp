package br.com.marvelkmp.database

import br.com.marvelkmp.app.MarvelDatabaseQueries
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class Database(private val driverFactory: DriverFactory) {
    private val mutex = Mutex()
    private var databaseQueries: MarvelDatabaseQueries? = null

    suspend fun getDatabaseQueries(): MarvelDatabaseQueries = mutex.withLock {
        databaseQueries ?: run {
            val driver = driverFactory.createDriver()
            MarvelDatabase(driver).marvelDatabaseQueries
        }
    }
}