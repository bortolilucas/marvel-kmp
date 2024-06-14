package br.com.marvelkmp.favorites.presentation.screen

sealed class FavoritesEvent {
    data object OnLaunch : FavoritesEvent()
    data object OnRetry : FavoritesEvent()
}