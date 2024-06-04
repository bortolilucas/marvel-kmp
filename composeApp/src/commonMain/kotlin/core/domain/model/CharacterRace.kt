package core.domain.model


sealed class CharacterRace(val type: CharacterRaceType) {
    data object Human : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanRadiation : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanClone : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanKree : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanSpartoi : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanVulcan : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanVuldarian : CharacterRace(CharacterRaceType.HUMAN)
    data object Inhuman : CharacterRace(CharacterRaceType.HUMAN)
    data object Mutant : CharacterRace(CharacterRaceType.HUMAN)
    data object Cyborg : CharacterRace(CharacterRaceType.HUMAN)
    data object Metahuman : CharacterRace(CharacterRaceType.HUMAN)
    data object Clone : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanAltered : CharacterRace(CharacterRaceType.HUMAN)
    data object HumanCosmic : CharacterRace(CharacterRaceType.HUMAN)
    data object Vampire : CharacterRace(CharacterRaceType.HUMAN)
    data object Zombie : CharacterRace(CharacterRaceType.HUMAN)

    data object Alien : CharacterRace(CharacterRaceType.ALIEN)
    data object Alpha : CharacterRace(CharacterRaceType.ALIEN)
    data object Amazon : CharacterRace(CharacterRaceType.ALIEN)
    data object Asgardian : CharacterRace(CharacterRaceType.ALIEN)
    data object Atlantean : CharacterRace(CharacterRaceType.ALIEN)
    data object Bizarro : CharacterRace(CharacterRaceType.ALIEN)
    data object BlackRacer : CharacterRace(CharacterRaceType.ALIEN)
    data object Bolovaxian : CharacterRace(CharacterRaceType.ALIEN)
    data object CosmicEntity : CharacterRace(CharacterRaceType.ALIEN)
    data object Czarnian : CharacterRace(CharacterRaceType.ALIEN)
    data object DathomirianZabrak : CharacterRace(CharacterRaceType.ALIEN)
    data object DemiGod : CharacterRace(CharacterRaceType.ALIEN)
    data object Demon : CharacterRace(CharacterRaceType.ALIEN)
    data object Eternal : CharacterRace(CharacterRaceType.ALIEN)
    data object FloraColossus : CharacterRace(CharacterRaceType.ALIEN)
    data object FrostGiant : CharacterRace(CharacterRaceType.ALIEN)
    data object GodEternal : CharacterRace(CharacterRaceType.ALIEN)
    data object Gungan : CharacterRace(CharacterRaceType.ALIEN)
    data object IcthyoSapien : CharacterRace(CharacterRaceType.ALIEN)
    data object Kaiju : CharacterRace(CharacterRaceType.ALIEN)
    data object Kakarantharaian : CharacterRace(CharacterRaceType.ALIEN)
    data object Korugaran : CharacterRace(CharacterRaceType.ALIEN)
    data object Kryptonian : CharacterRace(CharacterRaceType.ALIEN)
    data object Luphomoid : CharacterRace(CharacterRaceType.ALIEN)
    data object Maiar : CharacterRace(CharacterRaceType.ALIEN)
    data object Martian : CharacterRace(CharacterRaceType.ALIEN)
    data object NewGod : CharacterRace(CharacterRaceType.ALIEN)
    data object Neyaphem : CharacterRace(CharacterRaceType.ALIEN)
    data object Parademon : CharacterRace(CharacterRaceType.ALIEN)
    data object Rodian : CharacterRace(CharacterRaceType.ALIEN)
    data object Saiyan : CharacterRace(CharacterRaceType.ALIEN)
    data object Spartoi : CharacterRace(CharacterRaceType.ALIEN)
    data object Strontian : CharacterRace(CharacterRaceType.ALIEN)
    data object Symbiote : CharacterRace(CharacterRaceType.ALIEN)
    data object Talokite : CharacterRace(CharacterRaceType.ALIEN)
    data object Tamaranean : CharacterRace(CharacterRaceType.ALIEN)
    data object Ungaran : CharacterRace(CharacterRaceType.ALIEN)
    data object XenomorphXX121 : CharacterRace(CharacterRaceType.ALIEN)
    data object Yautja : CharacterRace(CharacterRaceType.ALIEN)
    data object YodaSpecies : CharacterRace(CharacterRaceType.ALIEN)
    data object ZenWhoberian : CharacterRace(CharacterRaceType.ALIEN)

    data object Android : CharacterRace(CharacterRaceType.ANDROID)

    data object Gorilla : CharacterRace(CharacterRaceType.ANIMAL)

    companion object {
        fun parse(race: String): CharacterRace = when (race) {
            "Human" -> Human
            "Human / Radiation" -> HumanRadiation
            "Human / Clone" -> HumanClone
            "Human-Kree" -> HumanKree
            "Human-Spartoi" -> HumanSpartoi
            "Human-Vulcan" -> HumanVulcan
            "Human-Vuldarian" -> HumanVuldarian
            "Inhuman" -> Inhuman
            "Mutant" -> Mutant
            "Cyborg" -> Cyborg
            "Metahuman" -> Metahuman
            "Clone" -> Clone
            "Human / Altered" -> HumanAltered
            "Human / Cosmic" -> HumanCosmic
            "Zombie" -> Zombie
            "Vampire" -> Vampire

            "Alien" -> Alien
            "Alpha" -> Alpha
            "Amazon" -> Amazon
            "Asgardian" -> Asgardian
            "Atlantean" -> Atlantean
            "Bizarro" -> Bizarro
            "Black Racer" -> BlackRacer
            "Bolovaxian" -> Bolovaxian
            "Cosmic Entity" -> CosmicEntity
            "Czarnian" -> Czarnian
            "Dathomirian Zabrak" -> DathomirianZabrak
            "Demi-God" -> DemiGod
            "Demon" -> Demon
            "Eternal" -> Eternal
            "Flora Colossus" -> FloraColossus
            "Frost Giant" -> FrostGiant
            "God / Eternal" -> GodEternal
            "Gungan" -> Gungan
            "Icthyo Sapien" -> IcthyoSapien
            "Kaiju" -> Kaiju
            "Kakarantharaian" -> Kakarantharaian
            "Korugaran" -> Korugaran
            "Kryptonian" -> Kryptonian
            "Luphomoid" -> Luphomoid
            "Maiar" -> Maiar
            "Martian" -> Martian
            "New God" -> NewGod
            "Neyaphem" -> Neyaphem
            "Parademon" -> Parademon
            "Rodian" -> Rodian
            "Saiyan" -> Saiyan
            "Spartoi" -> Spartoi
            "Strontian" -> Strontian
            "Symbiote" -> Symbiote
            "Talokite" -> Talokite
            "Tamaranean" -> Tamaranean
            "Ungaran" -> Ungaran
            "Xenomorph XX121" -> XenomorphXX121
            "Yautja" -> Yautja
            "Yoda's species" -> YodaSpecies
            "Zen-Whoberian" -> ZenWhoberian

            "Android" -> Android

            "Gorilla" -> Gorilla

            else -> Alien
        }
    }
}
