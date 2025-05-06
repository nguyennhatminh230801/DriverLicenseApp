package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.study.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.study.StudyScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToStudyScreen(navOptions: NavOptions? = null) {
    this.navigate(StudyNavigation.route, navOptions)
}

fun NavGraphBuilder.studyScreen(appState: AppState) {
    composable(route = StudyNavigation.route) {
        /*val viewModel : ComposeStudyViewModel = koinNavViewModel<ComposeStudyViewModel>()
        StudyRoute(appState = appState, viewModel = viewModel)*/
        StudyScreen()
    }
}


object StudyNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.STUDY
}