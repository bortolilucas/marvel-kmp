package br.com.marvelkmp.core.domain.mapper

import br.com.marvelkmp.core.data.mock.superhero.mockCharacterListResponseDto
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.model.CharacterAlignment
import br.com.marvelkmp.core.domain.model.CharacterImages
import br.com.marvelkmp.core.domain.model.CharacterPublisher
import br.com.marvelkmp.core.domain.model.CharacterRace
import kotlin.test.Test
import kotlin.test.assertEquals

class CharacterMapperTest {
    @Test
    fun `should map CharacterDto to Character`() {
        val characterDto = mockCharacterListResponseDto[0]

        val expectedCharacter = Character(
            id = characterDto.id,
            heroName = characterDto.name,
            realName = characterDto.biography.fullName,
            alignment = CharacterAlignment.parse(characterDto.biography.alignment),
            images = CharacterImages(
                sm = characterDto.images.sm,
                lg = characterDto.images.lg
            ),
            race = characterDto.appearance.race?.let { CharacterRace.parse(it) },
            publisher = characterDto.biography.publisher?.let { CharacterPublisher.parse(it) },
            weight = characterDto.appearance.weight.last(),
            height = characterDto.appearance.height.last(),
            gender = characterDto.appearance.gender,
            powerStats = characterDto.powerstats
        )

        val actualCharacter = characterDto.toDomain()

        assertEquals(expectedCharacter, actualCharacter)
    }
}