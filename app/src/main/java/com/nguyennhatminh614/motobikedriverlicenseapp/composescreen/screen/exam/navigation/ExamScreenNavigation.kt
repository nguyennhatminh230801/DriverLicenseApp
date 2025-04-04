package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.exam.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.exam.ExamScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToExamScreen(navOptions: NavOptions? = null) {
    this.navigate(ExamNavigation.route, navOptions)
}

fun NavGraphBuilder.examScreen(appState: AppState) {
    composable(route = ExamNavigation.route) {
        /*val viewModel : ComposeExamViewModel = koinNavViewModel<ComposeExamViewModel>()
        ExamRoute(appState = appState, viewModel = viewModel)*/
        ExamScreen()
    }
}


object ExamNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.EXAM
}