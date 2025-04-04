package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.mainscreen.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.components.NinePatchImage
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.MotorbikeDriverLicenseAppTheme
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.customColorsPalette
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.utils.annotations.DarkLightPreview
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.utils.draw9Patch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenNavigationDrawer(
    currentScreen: String,
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    onItemClick: (NavigationDrawerItemData) -> Unit = {},
    screenContent: @Composable BoxScope.() -> Unit = { Text("Content of the main screen") }
) {
    ModalNavigationDrawer(
        modifier = modifier.background(color = MaterialTheme.customColorsPalette.backgroundColor),
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight()
            ) {
                DrawerHeader()
                DrawerContent(
                    currentScreen = currentScreen,
                    onItemClick = {
                        scope.launch {
                            onItemClick(it)
                            drawerState.close()
                        }
                    }
                )
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("My App") }, navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    })
                }) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    content = screenContent
                )
            }
        })
}

@Composable
fun DrawerHeader() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.nav_header_height))
            .draw9Patch(
                context = context, ninePatchRes = R.drawable.side_nav_bar
            )
            .padding(
                start = dimensionResource(id = R.dimen.activity_horizontal_margin),
                top = dimensionResource(id = R.dimen.activity_vertical_margin),
                end = dimensionResource(id = R.dimen.activity_horizontal_margin),
                bottom = dimensionResource(id = R.dimen.activity_vertical_margin)
            ), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start
    ) {
        NinePatchImage(
            context = context,
            ninePatchRes = R.mipmap.ic_launcher_round,
            modifier = Modifier
                .size(56.dp)
                .padding(top = dimensionResource(id = R.dimen.nav_header_vertical_spacing))
        )
        Text(
            text = stringResource(id = R.string.nav_header_title),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.nav_header_vertical_spacing))
        )
        Text(
            text = stringResource(id = R.string.nav_header_subtitle),
            color = Color.White,
            modifier = Modifier.wrapContentWidth()
        )
    }
}

@Composable
fun DrawerContent(
    currentScreen: String,
    modifier: Modifier = Modifier,
    onItemClick: (NavigationDrawerItemData) -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.customColorsPalette.backgroundColor,
            )
            .padding(8.dp)
            .fillMaxHeight()
    ) {
        MainScreenFactory.getMenus().forEach { itemData ->
            key(itemData.id) {
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painterResource(id = itemData.icon),
                            contentDescription = stringResource(itemData.title)
                        )
                    },
                    label = { Text(text = stringResource(itemData.title)) },
                    selected = currentScreen == itemData.id,
                    onClick = {
                        onItemClick(itemData)
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.customColorsPalette.primaryColor.copy(
                            alpha = 0.3f
                        ),
                        selectedIconColor = MaterialTheme.customColorsPalette.primaryColor,
                        selectedTextColor = MaterialTheme.customColorsPalette.primaryColor,
                        unselectedContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }
    }
}

@Stable
data class NavigationDrawerItemData(
    val id: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
)

@DarkLightPreview
@Composable
fun PreviewDrawerWithHeader_ClosedScreen() {
    MotorbikeDriverLicenseAppTheme {
        MainScreenNavigationDrawer(
            currentScreen = MainScreenConstant.NAV_HOME,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        )
    }
}

@DarkLightPreview
@Composable
fun PreviewDrawerWithHeader_OpenScreen() {
    MotorbikeDriverLicenseAppTheme {
        MainScreenNavigationDrawer(
            currentScreen = MainScreenConstant.NAV_HOME,
            drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        )
    }
}

object MainScreenFactory {
    fun getMenus(): List<NavigationDrawerItemData> {
        return listOf(
            NavigationDrawerItemData(
                id = MainScreenConstant.NAV_HOME,
                title = R.string.home_navigation_home,
                icon = R.drawable.ic_baseline_home_24,
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_CHANGE_LICENSE_TYPE,
                title = R.string.home_navigation_change_license_class,
                icon = R.drawable.ic_change_license_type
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_EXAM,
                title = R.string.home_navigation_driving_test,
                icon = R.drawable.ic_menu_exam
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_STUDY,
                title = R.string.home_navigation_learn_theory,
                icon = R.drawable.ic_menu_study
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_TRAFFIC_SIGN,
                title = R.string.home_navigation_road_signs,
                icon = R.drawable.ic_menu_traffic_sign
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_TIPS_HIGH_SCORE,
                title = R.string.home_navigation_high_score_tips,
                icon = R.drawable.ic_menu_tips_high_scores
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_WRONG_ANSWER,
                title = R.string.home_navigation_incorrect_answers,
                icon = R.drawable.ic_menu_wrong_answer
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_INSTRUCTION,
                title = R.string.home_navigation_practical_test,
                icon = R.drawable.ic_baseline_rule_24
            ), NavigationDrawerItemData(
                id = MainScreenConstant.NAV_SETTINGS,
                title = R.string.home_navigation_settings,
                icon = R.drawable.ic_baseline_settings_24
            )
        )
    }
}

object MainScreenConstant {
    const val NAV_HOME: String = "nav_home"
    const val NAV_CHANGE_LICENSE_TYPE: String = "nav_change_license_type"
    const val NAV_EXAM: String = "nav_exam"
    const val NAV_STUDY: String = "nav_study"
    const val NAV_TRAFFIC_SIGN: String = "nav_traffic_sign"
    const val NAV_TIPS_HIGH_SCORE: String = "nav_tips_high_score"
    const val NAV_WRONG_ANSWER: String = "nav_wrong_answer"
    const val NAV_INSTRUCTION: String = "nav_instruction"
    const val NAV_SETTINGS: String = "nav_settings"
}
