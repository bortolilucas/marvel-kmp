package features.character.domain.usecase

import features.character.data.model.CharacterComic
import features.character.data.model.MarvelApiCharacterDetails
import features.character.domain.repository.CharacterDetailRepository

class GetCharacterComicsUseCase(
    private val characterDetailRepository: CharacterDetailRepository
) {
    suspend operator fun invoke(characterId: Int): Result<List<CharacterComic>> =
        runCatching {
            val response = characterDetailRepository.getCharacterComics(characterId)
            response.map { comic ->
                CharacterComic(
                    id = comic.id,
                    cover = comic.cover,
                    title = comic.title
                )
            }
        }
}