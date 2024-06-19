package br.com.marvelkmp.network.core.service

import MarvelKmp.network.core.BuildConfig.PUBLIC_KEY
import br.com.marvelkmp.network.core.utils.generateHash
import br.com.marvelkmp.network.core.utils.installContentNegotiation
import br.com.marvelkmp.network.core.utils.installLogging
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest

val marvelApiService = HttpClient {
    val generateHashReturn = generateHash()

    installLogging()
    installContentNegotiation()
    defaultRequest {
        url {
            url("https://gateway.marvel.com/v1/public/")
            parameters.append("apikey", PUBLIC_KEY)
            parameters.append("ts", generateHashReturn.timestamp)
            parameters.append("hash", generateHashReturn.hash)
        }
    }
}