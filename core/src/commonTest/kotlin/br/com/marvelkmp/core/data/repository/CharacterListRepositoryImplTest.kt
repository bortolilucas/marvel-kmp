package br.com.marvelkmp.core.data.repository

import br.com.marvelkmp.core.data.mock.superhero.mockCharacterListResponseDto
import br.com.marvelkmp.core.data.mock.superhero.mockMarvelCharacterList
import br.com.marvelkmp.core.data.service.CharacterListService
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CharacterListRepositoryImplTest {
    private val characterService = mock<CharacterListService>()
    private val repository = CharacterListRepositoryImpl(characterService)

    @Test
    fun `should return a list of marvel characters and map it to domain`() = runTest {
        everySuspend { characterService.getCharacters() } returns mockCharacterListResponseDto

        val marvelCharacters = repository.getMarvelCharacters()

        assertEquals(mockMarvelCharacterList, marvelCharacters)
    }
}