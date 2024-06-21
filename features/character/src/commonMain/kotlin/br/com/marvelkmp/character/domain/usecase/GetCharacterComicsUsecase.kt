package br.com.marvelkmp.character.domain.usecase

import br.com.marvelkmp.core.data.model.marvel.CharacterComic
import br.com.marvelkmp.core.domain.repository.CharacterDetailRepository

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