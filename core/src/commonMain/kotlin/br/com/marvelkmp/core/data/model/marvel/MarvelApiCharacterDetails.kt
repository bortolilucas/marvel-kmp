package br.com.marvelkmp.core.data.model.marvel

import br.com.marvelkmp.core.data.model.marvel.response.Comics

data class MarvelApiCharacterDetails(
    val comics: Comics,
    val biography: String,
    val id: Int,
)