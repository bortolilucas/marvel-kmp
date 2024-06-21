package br.com.marvelkmp.home.presentation

sealed class HomeEvent {
    data class OnSearch(val search: String) : HomeEvent()
    data object OnToggleSearchInput : HomeEvent()
    data object OnRetry : HomeEvent()
}