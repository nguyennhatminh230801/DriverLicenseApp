package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.tipshighscore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.tipshighscore.TipsHighScoreScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToTipsHighScoreScreen(navOptions: NavOptions? = null) {
    this.navigate(TipsHighScoreNavigation.route, navOptions)
}

fun NavGraphBuilder.tipsHighScoreScreen(appState: AppState) {
    composable(route = TipsHighScoreNavigation.route) {
        /*val viewModel : ComposeTipsHighScoreViewModel = koinNavViewModel<ComposeTipsHighScoreViewModel>()
        TipsHighScoreRoute(appState = appState, viewModel = viewModel)*/
        TipsHighScoreScreen()
    }
}


object TipsHighScoreNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.TIPS_HIGH_SCORE
}