package br.com.marvelkmp.network.service

import br.com.marvelkmp.logging.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val superHeroApiService = HttpClient {
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("HTTP Client", null, message)
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
            url("https://cdn.jsdelivr.net")
        }
    }
}