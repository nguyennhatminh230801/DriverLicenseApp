package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.trafficsign.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.trafficsign.TrafficSignScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToTrafficSignScreen(navOptions: NavOptions? = null) {
    this.navigate(TrafficSignNavigation.route, navOptions)
}

fun NavGraphBuilder.trafficSignScreen(appState: AppState) {
    composable(route = TrafficSignNavigation.route) {
        /*val viewModel : ComposeTrafficSignViewModel = koinNavViewModel<ComposeTrafficSignViewModel>()
        TrafficSignRoute(appState = appState, viewModel = viewModel)*/
        TrafficSignScreen()
    }
}


object TrafficSignNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.TRAFFIC_SIGN
}