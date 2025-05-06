package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation.RouteConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components.MainScreenConstant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

/**
 * Created by nguyennhatminh230801.
 */

@Composable
fun rememberAppState(
    context: Context,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState {
    return remember(context, navController, coroutineScope) {
        AppState(context, navController, coroutineScope)
    }
}

data class AppState(
    val context: Context,
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val isFinish: Boolean get() = navController.previousBackStackEntry == null

    val currentScreenNameStringId: Int
        @Composable get() = when (navController.currentBackStackEntryAsState().value?.destination?.route) {
            RouteConstant.CHANGE_LICENSE_TYPE -> R.string.home_navigation_change_license_class
            RouteConstant.EXAM -> R.string.home_navigation_driving_test
            RouteConstant.STUDY -> R.string.home_navigation_learn_theory
            RouteConstant.TRAFFIC_SIGN -> R.string.home_navigation_road_signs
            RouteConstant.TIPS_HIGH_SCORE -> R.string.home_navigation_high_score_tips
            RouteConstant.WRONG_ANSWER -> R.string.home_navigation_incorrect_answers
            RouteConstant.INSTRUCTION -> R.string.home_navigation_practical_test
            RouteConstant.SETTINGS -> R.string.home_navigation_settings
            else -> R.string.home_navigation_home
        }

    val currentScreenName: String
        @Composable get() = when (navController.currentBackStackEntryAsState().value?.destination?.route) {
            RouteConstant.CHANGE_LICENSE_TYPE -> MainScreenConstant.NAV_CHANGE_LICENSE_TYPE
            RouteConstant.EXAM -> MainScreenConstant.NAV_EXAM
            RouteConstant.STUDY -> MainScreenConstant.NAV_STUDY
            RouteConstant.TRAFFIC_SIGN -> MainScreenConstant.NAV_TRAFFIC_SIGN
            RouteConstant.TIPS_HIGH_SCORE -> MainScreenConstant.NAV_TIPS_HIGH_SCORE
            RouteConstant.WRONG_ANSWER -> MainScreenConstant.NAV_WRONG_ANSWER
            RouteConstant.INSTRUCTION -> MainScreenConstant.NAV_INSTRUCTION
            RouteConstant.SETTINGS -> MainScreenConstant.NAV_SETTINGS
            else -> MainScreenConstant.NAV_HOME
        }

    fun navigateUp() {
        navController.navigateUp()
    }
}