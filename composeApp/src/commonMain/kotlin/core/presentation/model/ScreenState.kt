package core.presentation.model

sealed class ScreenState {
    data object Loading : ScreenState()
    data object Error : ScreenState()
    data object Default : ScreenState()
    data object Search : ScreenState()
}