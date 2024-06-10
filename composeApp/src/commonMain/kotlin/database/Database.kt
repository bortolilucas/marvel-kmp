package database

import br.com.marvelkmp.app.MarvelDatabase

class Database(driverFactory: DriverFactory) {
    private val driver = driverFactory.createDriver()

    val databaseQueries = MarvelDatabase(driver).marvelDatabaseQueries
}