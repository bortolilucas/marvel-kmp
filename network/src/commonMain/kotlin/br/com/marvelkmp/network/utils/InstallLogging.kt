package br.com.marvelkmp.network.utils

import br.com.marvelkmp.logging.util.Log
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

fun HttpClientConfig<*>.installLogging() {
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("HTTP Client", null, message)
            }
        }
        level = LogLevel.HEADERS
    }
}