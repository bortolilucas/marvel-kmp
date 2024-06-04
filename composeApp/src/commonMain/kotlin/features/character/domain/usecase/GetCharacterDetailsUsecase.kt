package features.character.domain.usecase

import features.character.data.model.MarvelApiCharacterDetails
import features.character.domain.repository.CharacterDetailRepository

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