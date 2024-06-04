package features.home.domain.usecase

import core.domain.mapper.filterBy
import core.domain.model.Character
import core.presentation.model.CharacterFilter
import features.home.domain.repository.CharacterRepository

data class GetCharactersByTypeReturn(
    val heroes: List<Character>,
    val villains: List<Character>,
    val antiHeroes: List<Character>,
    val aliens: List<Character>,
    val humans: List<Character>,
)

class GetCharactersByTypeUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(): Result<GetCharactersByTypeReturn> = runCatching {
        val characters = characterRepository.getMarvelCharacters().shuffled()

        GetCharactersByTypeReturn(
            heroes = characters.filterByTypeAndLimit(CharacterFilter.HUMAN),
            villains = characters.filterByTypeAndLimit(CharacterFilter.VILLAIN),
            antiHeroes = characters.filterByTypeAndLimit(CharacterFilter.ANTIHERO),
            aliens = characters.filterByTypeAndLimit(CharacterFilter.ALIEN),
            humans = characters.filterByTypeAndLimit(CharacterFilter.HUMAN),
        )
    }

    private fun List<Character>.filterByTypeAndLimit(
        filterType: CharacterFilter
    ): List<Character> = filterBy(filterType).slice(0..10)
}