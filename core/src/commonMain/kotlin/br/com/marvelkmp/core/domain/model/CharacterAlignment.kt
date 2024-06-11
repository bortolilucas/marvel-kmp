package br.com.marvelkmp.core.domain.model

enum class CharacterAlignment {
    HERO,
    VILLAIN,
    ANTIHERO;

    companion object {
        fun parse(value: String): CharacterAlignment = when (value) {
            "good" -> HERO
            "bad" -> VILLAIN
            "neutral" -> ANTIHERO
            "-" -> ANTIHERO
            else -> throw IllegalArgumentException("Unknown alignment: $value")
        }
    }
}