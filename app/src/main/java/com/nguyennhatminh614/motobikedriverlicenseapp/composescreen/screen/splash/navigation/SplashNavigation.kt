package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.NavNoArg
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.navigation.navigateToMainScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.splash.SplashRoute

/**
 * Created by nguyennhatminh230801.
 */

fun NavController.navigateToSplash(navOptions: NavOptions? = null) {
    this.navigate(SplashNavigation.route, navOptions)
}

fun NavGraphBuilder.splashScreen(appState: AppState) {
    composable(route = SplashNavigation.route) {
        SplashRoute(
            onNavigateToMainScreen = {
                appState.navController.navigateToMainScreen(
                    navOptions = navOptions {
                        //Remove Splash screen after show main screen
                        popUpTo(SplashNavigation.route) {
                            inclusive = true
                        }
                    }
                )
            }
        )
    }
}

object SplashNavigation : NavNoArg() {
    override val route: String
        get() = RouteConstant.SPLASH
}