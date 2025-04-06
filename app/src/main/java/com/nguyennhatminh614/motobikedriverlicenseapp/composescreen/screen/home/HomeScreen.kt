package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.navOptions
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.AppState

import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.components.NinePatchImage
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.rememberAppState
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.exam.navigation.navigateToExamScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.home.navigation.HomeNavigation
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.instruction.navigation.navigateToInstructionScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.licensetype.navigation.navigateToChangeLicenseScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components.MainScreenConstant
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.settings.navigation.navigateToSettingsScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.study.navigation.navigateToStudyScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.tipshighscore.navigation.navigateToTipsHighScoreScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.trafficsign.navigation.navigateToTrafficSignScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.wronganswer.navigation.navigateToWrongAnswerScreen
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.MotorbikeDriverLicenseAppTheme
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.customFontStyle
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.utils.annotations.DarkLightPreview

@Composable
fun HomeScreen(
    appState: AppState,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit = {}
) {
    val menu = HomeScreenFactory.getMenus()
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(menu.size) { index ->
            val item = menu[index]
            Card(
                modifier = Modifier
                    .clickable {
                        /*val navOption = navOptions {
                            popUpTo(HomeNavigation.route) {
                                inclusive = false
                            }
                        }

                        when(item.id) {
                            MainScreenConstant.NAV_CHANGE_LICENSE_TYPE -> appState.navController.navigateToChangeLicenseScreen( navOption)
                            MainScreenConstant.NAV_EXAM -> appState.navController.navigateToExamScreen(navOption)
                            MainScreenConstant.NAV_STUDY -> appState.navController.navigateToStudyScreen(navOption)
                            MainScreenConstant.NAV_TRAFFIC_SIGN -> appState.navController.navigateToTrafficSignScreen(navOption)
                            MainScreenConstant.NAV_TIPS_HIGH_SCORE -> appState.navController.navigateToTipsHighScoreScreen(navOption)
                            MainScreenConstant.NAV_WRONG_ANSWER -> appState.navController.navigateToWrongAnswerScreen(navOption)
                            MainScreenConstant.NAV_INSTRUCTION -> appState.navController.navigateToInstructionScreen(navOption)
                            MainScreenConstant.NAV_SETTINGS -> appState.navController.navigateToSettingsScreen(navOption)
                        }*/
                        onItemClick(item.id)
                    }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    NinePatchImage(
                        context = context,
                        ninePatchRes = item.icon,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(60.dp),
                    )

                    Text(
                        text = context.getString(item.title),
                        style = MaterialTheme.customFontStyle.textStyleNormal,
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                    )
                }
            }
        }
    }
}

object HomeScreenFactory {
    fun getMenus(): List<HomeScreenItemData> {
        return listOf(
            HomeScreenItemData(
                id = MainScreenConstant.NAV_EXAM,
                title = R.string.home_navigation_driving_test,
                icon = R.drawable.ic_exam
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_STUDY,
                title = R.string.home_navigation_learn_theory,
                icon = R.drawable.ic_study
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_TRAFFIC_SIGN,
                title = R.string.home_navigation_road_signs,
                icon = R.drawable.ic_signal
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_TIPS_HIGH_SCORE,
                title = R.string.home_navigation_high_score_tips,
                icon = R.drawable.ic_tips_high_score
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_WRONG_ANSWER,
                title = R.string.home_navigation_incorrect_answers,
                icon = R.drawable.ic_wrong_answer
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_INSTRUCTION,
                title = R.string.home_navigation_practical_test,
                icon = R.drawable.ic_driving_business
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_CHANGE_LICENSE_TYPE,
                title = R.string.home_navigation_change_license_class,
                icon = R.drawable.ic_change_license_type_main_screen
            ),
            HomeScreenItemData(
                id = MainScreenConstant.NAV_SETTINGS,
                title = R.string.home_navigation_settings,
                icon = R.drawable.ic_settings
            )
        )
    }
}

@Stable
data class HomeScreenItemData(
    val id: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
)

@DarkLightPreview
@Composable
fun PreviewHomeScreen() {
    MotorbikeDriverLicenseAppTheme {
        HomeScreen(
            appState = rememberAppState(LocalContext.current)
        )
    }
}

