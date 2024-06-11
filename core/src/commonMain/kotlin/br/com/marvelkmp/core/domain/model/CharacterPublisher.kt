package br.com.marvelkmp.core.domain.model

sealed class CharacterPublisher(val name: String) {
    data object Marvel : CharacterPublisher("Marvel Comics")
    data class Other(val publisher: String) : CharacterPublisher(publisher)

    companion object {
        fun parse(publisher: String): CharacterPublisher = when (publisher) {
            "Marvel Comics" -> Marvel
            else -> Other(publisher)
        }
    }
}