package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.ComposeMainViewModel
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.MainRoute
import org.koin.androidx.compose.navigation.koinNavViewModel


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToMainScreen(navOptions: NavOptions? = null) {
    this.navigate(MainNavigation.route, navOptions)
}

fun NavGraphBuilder.mainScreen() {
    composable(route = MainNavigation.route) {
        val viewModel : ComposeMainViewModel = koinNavViewModel<ComposeMainViewModel>()
        MainRoute(viewModel = viewModel)
    }
}


object MainNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.MAIN_SCREEN
}