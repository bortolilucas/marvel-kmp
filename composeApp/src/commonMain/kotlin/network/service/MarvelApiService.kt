package network.service

import MarvelKmp.composeApp.BuildConfig.PUBLIC_KEY
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.utils.generateHash

val marvelApiService = HttpClient {
    val generateHashReturn = generateHash()

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Napier.v("HTTP Client", null, message)
            }
        }
        level = LogLevel.HEADERS
    }
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }
    defaultRequest {
        url {
            url("https://gateway.marvel.com/v1/public/")
            parameters.append("apikey", PUBLIC_KEY)
            parameters.append("ts", generateHashReturn.timestamp)
            parameters.append("hash", generateHashReturn.hash)
        }
    }
}