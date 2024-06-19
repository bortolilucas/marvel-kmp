package br.com.marvelkmp.network.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json

fun mockHttpClient(
    response: String,
    status: HttpStatusCode = HttpStatusCode.OK,
): HttpClient {
    val engine = MockEngine {
        respond(
            content = response,
            status = status,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    return HttpClient(engine) {
        install(ContentNegotiation) { json() }
    }
}