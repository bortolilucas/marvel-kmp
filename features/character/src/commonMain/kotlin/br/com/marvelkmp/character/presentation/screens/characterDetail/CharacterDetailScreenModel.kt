package br.com.marvelkmp.character.presentation.screens.characterDetail

import br.com.marvelkmp.character.domain.mapper.toCharacterDetails
import br.com.marvelkmp.character.domain.usecase.GetCharacterComicsUseCase
import br.com.marvelkmp.character.domain.usecase.GetCharacterDetailsUseCase
import br.com.marvelkmp.character.domain.usecase.RemoveFavoriteUseCase
import br.com.marvelkmp.character.domain.usecase.VerifyIsFavoriteUseCase
import br.com.marvelkmp.character.presentation.screens.characterDetail.model.CharacterDetailEvent
import br.com.marvelkmp.character.presentation.screens.characterDetail.model.CharacterDetailState
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.domain.usecase.AddFavoriteUseCase
import br.com.marvelkmp.core.presentation.model.ScreenState
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailScreenModel(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val verifyIsFavoriteUseCase: VerifyIsFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : StateScreenModel<CharacterDetailState>(CharacterDetailState()) {

    fun onEvent(event: CharacterDetailEvent) = when (event) {
        is CharacterDetailEvent.OnLaunch -> {
            getCharacterDetails(event.character)
            verifyIsFavorite(event.character.id)
        }

        is CharacterDetailEvent.OnRetry -> getCharacterDetails(event.character)
        is CharacterDetailEvent.OnToggleFavorite -> toggleFavorite(event.character)
    }

    private fun getCharacterComics(
        marvelApiCharacterId: Int, character: Character, marvelApiCharacterBio: String? = null
    ) = screenModelScope.launch {
        getCharacterComicsUseCase(marvelApiCharacterId).onSuccess { comics ->
            mutableState.update {
                it.copy(
                    state = ScreenState.Default,
                    character = character.toCharacterDetails(
                        marvelApiCharacterBio.orEmpty(),
                        comics
                    )
                )
            }
        }.onFailure {
            mutableState.update { it.copy(state = ScreenState.Error) }
        }
    }

    private fun getCharacterDetails(character: Character) = screenModelScope.launch {
        mutableState.update { it.copy(state = ScreenState.Loading) }

        getCharacterDetailsUseCase(character.heroName).onSuccess { marvelApiCharacter ->
            getCharacterComics(
                marvelApiCharacter.id, character, marvelApiCharacter.biography
            )
        }.onFailure {
            mutableState.update { it.copy(state = ScreenState.Error) }
        }
    }

    private fun toggleFavorite(character: Character) = screenModelScope.launch {
        if (state.value.isFavorite) {
            val result = removeFavoriteUseCase.invoke(character.id)

            if (result.isSuccess)
                mutableState.update { it.copy(isFavorite = false) }

            return@launch
        }

        val result = addFavoriteUseCase.invoke(character)

        if (result.isSuccess)
            mutableState.update { it.copy(isFavorite = true) }
    }

    private fun verifyIsFavorite(characterId: Int) = screenModelScope.launch {
        verifyIsFavoriteUseCase(characterId).onSuccess { isFavorite ->
            mutableState.update { it.copy(isFavorite = isFavorite) }
        }.onFailure {
            mutableState.update { it.copy(isFavorite = false) }
        }
    }
}