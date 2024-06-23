package br.com.marvelkmp.character.presentation.screens.characterList

import app.cash.turbine.test
import br.com.marvelkmp.character.domain.mock.mockCharactersList
import br.com.marvelkmp.character.domain.usecase.GetCharacterListUseCase
import br.com.marvelkmp.core.domain.mapper.filterBy
import br.com.marvelkmp.core.presentation.model.CharacterFilter
import br.com.marvelkmp.core.presentation.model.ScreenState
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListScreenModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private val getCharacterListUseCase = mock<GetCharacterListUseCase>()

    private lateinit var screenModel: CharacterListScreenModel

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        screenModel = CharacterListScreenModel(getCharacterListUseCase)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should fetch heroes list when OnLaunch event is triggered`() = runTest {
        val type = CharacterFilter.HERO
        val expectedList = mockCharactersList.filterBy(type)

        everySuspend { getCharacterListUseCase(type) } returns Result.success(expectedList)

        screenModel.onEvent(CharacterListEvent.OnLaunch(type))

        screenModel.state.test {
            val itemBeforeFetch = awaitItem()
            assertEquals(ScreenState.Loading, itemBeforeFetch.state)

            val itemAfterFetch = awaitItem()

            assertEquals(ScreenState.Default, itemAfterFetch.state)
            assertEquals(expectedList, itemAfterFetch.characters)
        }
    }

    @Test
    fun `should fetch heroes list when OnRetry event is triggered`() = runTest {
        val type = CharacterFilter.HERO
        val expectedList = mockCharactersList.filterBy(type)

        everySuspend { getCharacterListUseCase(type) } returns Result.success(expectedList)

        screenModel.onEvent(CharacterListEvent.OnRetry(type))

        screenModel.state.test {
            val itemBeforeFetch = awaitItem()
            assertEquals(ScreenState.Loading, itemBeforeFetch.state)

            val itemAfterFetch = awaitItem()

            assertEquals(ScreenState.Default, itemAfterFetch.state)
            assertEquals(expectedList, itemAfterFetch.characters)
        }
    }

    @Test
    fun `should set error state when fetching fails`() = runTest {
        val type = CharacterFilter.HERO

        everySuspend { getCharacterListUseCase(type) } returns Result.failure(Exception())

        screenModel.onEvent(CharacterListEvent.OnLaunch(type))

        screenModel.state.test {
            assertEquals(ScreenState.Loading, awaitItem().state)
            assertEquals(ScreenState.Error, awaitItem().state)
        }
    }
}