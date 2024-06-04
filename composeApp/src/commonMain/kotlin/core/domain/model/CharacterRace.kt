package core.domain.model

sealed class CharacterRace(val name: String) {
    data object Human : CharacterRace("Human")
    data class Aliens(val race: String) : CharacterRace(race)

    companion object {
        fun parse(race: String): CharacterRace = when (race) {
            "Human" -> Human
            else -> Aliens(race)
        }
    }
}