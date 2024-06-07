package database

import br.com.marvelkmp.app.CharactersEntity
import br.com.marvelkmp.app.MarvelDatabase

class Database(driverFactory: DriverFactory) {
    val driver = driverFactory.createDriver()
    val database = MarvelDatabase(driver)

    fun getCharacters(): List<CharactersEntity> {
        return database.marvelDatabaseQueries.getCharacters().executeAsList()
    }
}