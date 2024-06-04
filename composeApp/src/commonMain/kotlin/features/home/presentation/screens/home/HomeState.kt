package features.home.presentation.screens.home

import core.presentation.model.ListSection
import core.presentation.model.ScreenState
import core.domain.model.Character
import features.home.domain.usecase.GetCharactersByTypeReturn

data class HomeState(
    val state: ScreenState = ScreenState.Loading,
    val sections: List<ListSection<Character>> = emptyList()
)

fun GetCharactersByTypeReturn.toHomeSections(): List<ListSection<Character>> = listOf(
    ListSection("Heroes", heroes),
    ListSection("Villains", villains),
    ListSection("Anti-Heroes", antiHeroes),
    ListSection("Aliens", aliens),
    ListSection("Humans", humans)
).filter { it.data.isNotEmpty() }