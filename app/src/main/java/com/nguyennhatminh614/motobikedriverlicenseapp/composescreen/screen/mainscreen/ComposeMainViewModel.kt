package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen

import androidx.compose.runtime.Stable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components.MainScreenConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.utils.base.BaseComposeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ComposeMainViewModel : BaseComposeViewModel() {
    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    fun updateCurrentScreen(currentScreen: String) {
        _uiState.update {
            it.copy(currentScreen = currentScreen)
        }
    }

    @Stable
    data class MainScreenUiState(
        val currentScreen: String = MainScreenConstant.NAV_HOME,
    )
}