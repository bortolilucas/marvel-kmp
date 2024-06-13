package br.com.marvelkmp.network.service

import br.com.marvelkmp.network.utils.installContentNegotiation
import br.com.marvelkmp.network.utils.installLogging
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest

val superHeroApiService = HttpClient {
    installLogging()
    installContentNegotiation()
    defaultRequest {
        url {
            url("https://cdn.jsdelivr.net")
        }
    }
}