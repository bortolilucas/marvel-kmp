package features.character.presentation.screens.characterDetail

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.domain.model.Character
import core.presentation.model.ScreenState
import features.character.data.model.CharacterDetails
import features.character.domain.usecase.GetCharacterComicsUseCase
import features.character.domain.usecase.GetCharacterDetailsUseCase
import features.character.presentation.screens.characterDetail.model.CharacterDetailState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailScreenModel(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase
) : StateScreenModel<CharacterDetailState>(CharacterDetailState()) {

    private fun getCharacterComics(
        marvelApiCharacterId: Int,
        character: Character,
        marvelApiCharacterBio: String? = null
    ) = screenModelScope.launch {
        getCharacterComicsUseCase(marvelApiCharacterId)
            .onSuccess { comics ->
                mutableState.update {
                    it.copy(
                        state = ScreenState.Default,
                        character = CharacterDetails(
                            id = character.id,
                            backgroundImage = character.images.lg ?: character.images.sm,
                            realName = character.realName,
                            name = character.heroName,
                            biography = marvelApiCharacterBio,
                            height = character.height ?: "",
                            weight = character.weight ?: "",
                            race = character.race?.name ?: "",
                            stats = character.powerStats,
                            gender = character.gender,
                            comics = comics
                        )
                    )
                }
            }.onFailure {
                mutableState.update { it.copy(state = ScreenState.Error) }
            }
    }

    fun getCharacterDetails(character: Character) = screenModelScope.launch {
        mutableState.update { it.copy(state = ScreenState.Loading) }

        getCharacterDetailsUseCase(character.heroName)
            .onSuccess { marvelApiCharacter ->
                getCharacterComics(
                    marvelApiCharacter.id,
                    character,
                    marvelApiCharacter.biography
                )
            }
            .onFailure {
                mutableState.update { it.copy(state = ScreenState.Error) }
            }
    }
}