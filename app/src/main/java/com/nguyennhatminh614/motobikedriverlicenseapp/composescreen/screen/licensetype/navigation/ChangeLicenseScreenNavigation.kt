package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.licensetype.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.licensetype.ChangeLicenseScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToChangeLicenseScreen(navOptions: NavOptions? = null) {
    this.navigate(ChangeLicenseNavigation.route, navOptions)
}

fun NavGraphBuilder.changeLicenseScreen(appState: AppState) {
    composable(route = ChangeLicenseNavigation.route) {
        /*val viewModel : ComposeChangeLicenseViewModel = koinNavViewModel<ComposeChangeLicenseViewModel>()
        ChangeLicenseRoute(appState = appState, viewModel = viewModel)*/
        ChangeLicenseScreen()
    }
}


object ChangeLicenseNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.CHANGE_LICENSE_TYPE
}