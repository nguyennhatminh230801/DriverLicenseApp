package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.wronganswer.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.wronganswer.WrongAnswerScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToWrongAnswerScreen(navOptions: NavOptions? = null) {
    this.navigate(WrongAnswerNavigation.route, navOptions)
}

fun NavGraphBuilder.wrongAnswerScreen(appState: AppState) {
    composable(route = WrongAnswerNavigation.route) {
        /*val viewModel : ComposeWrongAnswerViewModel = koinNavViewModel<ComposeWrongAnswerViewModel>()
        WrongAnswerRoute(appState = appState, viewModel = viewModel)*/
        WrongAnswerScreen()
    }
}


object WrongAnswerNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.WRONG_ANSWER
}