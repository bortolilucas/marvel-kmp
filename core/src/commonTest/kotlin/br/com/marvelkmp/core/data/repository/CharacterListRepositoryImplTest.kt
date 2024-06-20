package br.com.marvelkmp.core.data.repository

import br.com.marvelkmp.core.data.fake.FakeCharacterListService
import br.com.marvelkmp.core.data.mock.superhero.mockCharacterListResponseDto
import br.com.marvelkmp.core.data.mock.superhero.mockMarvelCharacterList
import br.com.marvelkmp.core.domain.repository.CharacterListRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CharacterListRepositoryImplTest {
    private lateinit var characterService: FakeCharacterListService
    private lateinit var repository: CharacterListRepository

    @BeforeTest
    fun setUp() {
        characterService = FakeCharacterListService()
        repository = CharacterListRepositoryImpl(characterService)

        characterService.addCharacters(mockCharacterListResponseDto)
    }

    @Test
    fun `should return a list of marvel characters and map it to domain`() = runTest {
        val marvelCharacters = repository.getMarvelCharacters()

        assertEquals(mockMarvelCharacterList, marvelCharacters)
    }
}