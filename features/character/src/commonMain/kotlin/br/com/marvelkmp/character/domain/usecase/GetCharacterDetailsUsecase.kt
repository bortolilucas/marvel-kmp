package br.com.marvelkmp.character.domain.usecase

import br.com.marvelkmp.core.data.model.marvel.MarvelApiCharacterDetails
import br.com.marvelkmp.core.domain.repository.CharacterDetailRepository

class GetCharacterDetailsUseCase(
    private val characterDetailRepository: CharacterDetailRepository
) {
    suspend operator fun invoke(characterName: String): Result<MarvelApiCharacterDetails> =
        runCatching {
            val response = characterDetailRepository.getCharacterDetails(characterName)

            MarvelApiCharacterDetails(
                id = response.id,
                biography = response.biography,
                comics = response.comics
            )
        }
}