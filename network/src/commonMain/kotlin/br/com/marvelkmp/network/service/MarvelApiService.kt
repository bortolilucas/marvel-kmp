package br.com.marvelkmp.network.service

import MarvelKmp.network.BuildConfig.PUBLIC_KEY
import br.com.marvelkmp.network.utils.generateHash
import br.com.marvelkmp.network.utils.installContentNegotiation
import br.com.marvelkmp.network.utils.installLogging
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