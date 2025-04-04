package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.rememberAppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components.MainScreenConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components.MainScreenNavigationDrawer
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.MotorbikeDriverLicenseAppTheme
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.utils.annotations.DarkLightPreview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.exam.navigation.examScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.exam.navigation.navigateToExamScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation.HomeNavigation
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation.homeScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation.navigateToHomeScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.instruction.navigation.instructionScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.instruction.navigation.navigateToInstructionScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.licensetype.navigation.changeLicenseScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.licensetype.navigation.navigateToChangeLicenseScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.settings.navigation.navigateToSettingsScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.settings.navigation.settingsScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.study.navigation.navigateToStudyScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.study.navigation.studyScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.tipshighscore.navigation.navigateToTipsHighScoreScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.tipshighscore.navigation.tipsHighScoreScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.trafficsign.navigation.navigateToTrafficSignScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.trafficsign.navigation.trafficSignScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.wronganswer.navigation.navigateToWrongAnswerScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.wronganswer.navigation.wrongAnswerScreen

@Composable
fun MainRoute(
    appState: AppState,
    modifier: Modifier = Modifier,
    viewModel: ComposeMainViewModel
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()

    val uiState: ComposeMainViewModel.MainScreenUiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = uiState.currentScreen) {
        val navOption = navOptions {
            popUpTo(HomeNavigation.route) {
                inclusive = false
            }
        }

        when (uiState.currentScreen) {
            MainScreenConstant.NAV_HOME -> navController.navigateToHomeScreen(navOption)
            MainScreenConstant.NAV_CHANGE_LICENSE_TYPE -> navController.navigateToChangeLicenseScreen(navOption)
            MainScreenConstant.NAV_EXAM -> navController.navigateToExamScreen(navOption)
            MainScreenConstant.NAV_STUDY -> navController.navigateToStudyScreen(navOption)
            MainScreenConstant.NAV_TRAFFIC_SIGN -> navController.navigateToTrafficSignScreen(navOption)
            MainScreenConstant.NAV_TIPS_HIGH_SCORE -> navController.navigateToTipsHighScoreScreen(navOption)
            MainScreenConstant.NAV_WRONG_ANSWER -> navController.navigateToWrongAnswerScreen(navOption)
            MainScreenConstant.NAV_INSTRUCTION -> navController.navigateToInstructionScreen(navOption)
            MainScreenConstant.NAV_SETTINGS -> navController.navigateToSettingsScreen(navOption)
        }
    }

    MainScreen(
        appState = appState,
        modifier = modifier,
        drawerState = drawerState,
        currentScreen = uiState.currentScreen,
        onUpdateCurrentScreen = { currentScreen ->
            viewModel.updateCurrentScreen(currentScreen)
        },
        navController = navController,
    )
}

@Composable
internal fun MainScreen(
    appState: AppState,
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    currentScreen: String,
    onUpdateCurrentScreen: (String) -> Unit = {},
    navController: NavHostController = rememberNavController()
) {
    MainScreenNavigationDrawer(
        currentScreen = currentScreen,
        modifier = modifier,
        scope = appState.coroutineScope,
        drawerState = drawerState,
        onItemClick = { item ->
            onUpdateCurrentScreen(item.id)
        },
        screenContent = {
            NavHost(
                navController = navController,
                startDestination = HomeNavigation.route,
            ) {
                homeScreen(appState)
                settingsScreen(appState)
                examScreen(appState)
                studyScreen(appState)
                trafficSignScreen(appState)
                tipsHighScoreScreen(appState)
                wrongAnswerScreen(appState)
                instructionScreen(appState)
                changeLicenseScreen(appState)
            }
        }
    )
}

@DarkLightPreview
@Composable
private fun MainScreenPreview() {
    MotorbikeDriverLicenseAppTheme {
        MainScreen(
            currentScreen = MainScreenConstant.NAV_HOME,
            appState = rememberAppState(LocalContext.current)
        )
    }
}