package br.com.marvelkmp.network.core.service

import br.com.marvelkmp.network.core.utils.installContentNegotiation
import br.com.marvelkmp.network.core.utils.installLogging
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