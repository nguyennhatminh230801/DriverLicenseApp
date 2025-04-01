package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation.homeScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.splash.navigation.SplashNavigation
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.splash.navigation.splashScreen

/**
 * Created by nguyennhatminh230801.
 */
@Composable
internal fun AppNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
    startDestination: String = SplashNavigation.route
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        splashScreen(appState = appState)
        homeScreen(appState = appState)
    }
}