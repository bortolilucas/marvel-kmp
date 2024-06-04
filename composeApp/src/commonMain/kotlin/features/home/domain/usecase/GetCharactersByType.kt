package features.home.domain.usecase

import core.domain.model.Character
import core.domain.model.CharacterAlignment
import core.domain.model.CharacterRaceType
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
            heroes = characters.filterAndLimit { it.alignment == CharacterAlignment.HERO },
            villains = characters.filterAndLimit { it.alignment == CharacterAlignment.VILLAIN },
            antiHeroes = characters.filterAndLimit { it.alignment == CharacterAlignment.ANTIHERO },
            aliens = characters.filterAndLimit { it.race?.type == CharacterRaceType.ALIEN },
            humans = characters.filterAndLimit { it.race?.type == CharacterRaceType.HUMAN },
        )
    }

    private fun List<Character>.filterAndLimit(
        predicate: (Character) -> Boolean
    ): List<Character> = filter(predicate).slice(0..10)
}