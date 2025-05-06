package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.instruction.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.instruction.InstructionScreen


/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToInstructionScreen(navOptions: NavOptions? = null) {
    this.navigate(InstructionNavigation.route, navOptions)
}

fun NavGraphBuilder.instructionScreen(appState: AppState) {
    composable(route = InstructionNavigation.route) {
        /*val viewModel : ComposeInstructionViewModel = koinNavViewModel<ComposeInstructionViewModel>()
        InstructionRoute(appState = appState, viewModel = viewModel)*/
        InstructionScreen()
    }
}


object InstructionNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.INSTRUCTION
}