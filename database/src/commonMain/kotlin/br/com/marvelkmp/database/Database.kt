package br.com.marvelkmp.database


class Database(driverFactory: DriverFactory) {
    private val driver = driverFactory.createDriver()

    val databaseQueries = MarvelDatabase(driver).marvelDatabaseQueries
}