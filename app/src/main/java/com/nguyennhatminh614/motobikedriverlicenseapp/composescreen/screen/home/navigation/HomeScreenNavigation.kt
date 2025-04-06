package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.HomeScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.ComposeMainViewModel
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.MainRoute
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components.NavigationDrawerItemData
import org.koin.androidx.compose.navigation.koinNavViewModel


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(HomeNavigation.route, navOptions) 
}

fun NavGraphBuilder.homeScreen(appState: AppState, onItemClick: (String) -> Unit = {}) {
    composable(route = HomeNavigation.route) {
        HomeScreen(appState, onItemClick = onItemClick)
    }
}


object HomeNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.HOME
}