package features.character.presentation.screens.characterDetail

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.domain.model.Character
import core.presentation.model.ScreenState
import features.character.data.model.CharacterDetails
import features.character.domain.usecase.GetCharacterDetailsUseCase
import features.character.presentation.screens.characterDetail.model.CharacterDetailState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailScreenModel(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : StateScreenModel<CharacterDetailState>(CharacterDetailState()) {

    fun getCharacterDetails(character: Character) = screenModelScope.launch {
        mutableState.update { it.copy(state = ScreenState.Loading) }

        getCharacterDetailsUseCase(character.heroName)
            .onSuccess { marvelApiCharacter ->
                mutableState.update {
                    it.copy(
                        state = ScreenState.Default,
                        character = CharacterDetails(
                            id = character.id,
                            backgroundImage = character.images.lg ?: character.images.sm,
                            realName = character.realName,
                            name = character.heroName,
                            biography = marvelApiCharacter.biography,
                            height = character.height ?: "",
                            weight = character.weight ?: "",
                            race = character.race?.name ?: "",
                            stats = character.powerStats,
                            gender = character.gender
                        )
                    )
                }
            }
            .onFailure {
                mutableState.update { it.copy(state = ScreenState.Error) }
            }
    }
}