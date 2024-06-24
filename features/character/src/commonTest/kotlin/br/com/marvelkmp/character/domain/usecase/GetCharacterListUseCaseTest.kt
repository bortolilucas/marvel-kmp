package br.com.marvelkmp.character.domain.usecase

import br.com.marvelkmp.character.domain.mock.mockCharactersList
import br.com.marvelkmp.core.domain.mapper.filterBy
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.repository.CharacterListRepository
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetCharacterListUseCaseTest {
    private val repository = mock<CharacterListRepository>()
    private val useCase = GetCharacterListUseCaseImpl(repository)

    @Test
    fun `should return result success with all characters`() = runTest {
        everySuspend { repository.getMarvelCharacters() } returns mockCharactersList

        val expectedResult = Result.success(mockCharactersList)
        val actualResult = useCase()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `should return result success with characters filtered by type`() = runTest {
        val type = CharacterFilter.HERO
        val expectedFilteredList = mockCharactersList.filterBy(type)

        everySuspend { repository.getMarvelCharacters() } returns mockCharactersList

        val expectedResult = Result.success(expectedFilteredList)
        val actualResult = useCase(type)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `should return result failure when exception is thrown`() = runTest {
        val expectedException = Exception()

        everySuspend { repository.getMarvelCharacters() } throws expectedException

        val expectedResult = Result.failure<List<Character>>(expectedException)
        val actualResult = useCase()

        assertEquals(expectedResult, actualResult)
    }
}