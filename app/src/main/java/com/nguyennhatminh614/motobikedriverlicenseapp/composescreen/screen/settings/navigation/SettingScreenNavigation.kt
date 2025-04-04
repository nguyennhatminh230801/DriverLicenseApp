package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.settings.SettingsScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToSettingsScreen(navOptions: NavOptions? = null) {
    this.navigate(SettingsNavigation.route, navOptions)
}

fun NavGraphBuilder.settingsScreen(appState: AppState) {
    composable(route = SettingsNavigation.route) {
        /*val viewModel : ComposeSettingsViewModel = koinNavViewModel<ComposeSettingsViewModel>()
        SettingsRoute(appState = appState, viewModel = viewModel)*/
        SettingsScreen()
    }
}


object SettingsNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.SETTINGS
}