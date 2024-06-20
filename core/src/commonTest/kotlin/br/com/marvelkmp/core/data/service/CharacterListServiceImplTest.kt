package br.com.marvelkmp.core.data.service

import br.com.marvelkmp.core.data.mock.superhero.mockCharacterListResponseDto
import br.com.marvelkmp.core.data.mock.superhero.mockCharacterListResponseJson
import br.com.marvelkmp.network.service.mockHttpClient
import io.ktor.client.HttpClient
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CharacterListServiceImplTest {
    private lateinit var httpClient: HttpClient
    private lateinit var characterListService: CharacterListService

    @BeforeTest
    fun setUp() {
        httpClient = mockHttpClient(
            response = mockCharacterListResponseJson,
            status = HttpStatusCode.OK
        )
        characterListService = CharacterListServiceImpl(httpClient)
    }

    @Test
    fun `should return list of characters`() = runTest {
        val characters = characterListService.getCharacters()
        assertEquals(characters, mockCharacterListResponseDto)
    }
}