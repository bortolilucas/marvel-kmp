package features.favorites.domain.usecase

import br.com.marvelkmp.core.domain.model.Character
import features.favorites.data.repository.FavoritesRepository

class GetFavoritesUseCase(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(): Result<List<Character>> = runCatching {
        val response = repository.getFavorites()

        response.map {
            Character(
                id = it.id,
                heroName = it.heroName,
                realName = it.realName,
                gender = it.gender,
                race = it.race,
                height = it.height,
                weight = it.weight,
                alignment = it.alignment,
                publisher = it.publisher,
                powerStats = it.powerStats,
                appearance = it.appearance,
                images = it.images
            )
        }
    }
}