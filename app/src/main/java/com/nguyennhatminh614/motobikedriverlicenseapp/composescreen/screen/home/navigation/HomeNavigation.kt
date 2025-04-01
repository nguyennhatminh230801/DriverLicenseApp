package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.HomeRoute


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(HomeNavigation.route, navOptions)
}

fun NavGraphBuilder.homeScreen(appState: AppState) {
    composable(route = HomeNavigation.route) {
        HomeRoute()
    }
}


object HomeNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.HOME
}