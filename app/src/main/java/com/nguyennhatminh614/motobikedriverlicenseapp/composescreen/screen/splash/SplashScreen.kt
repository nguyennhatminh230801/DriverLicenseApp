package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.components.NinePatchImage
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.MotorbikeDriverLicenseAppTheme
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.customColorsPalette
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.customFontStyle
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.utils.annotations.DarkLightPreview
import com.nguyennhatminh614.motobikedriverlicenseapp.utils.constant.AppConstant
import kotlinx.coroutines.delay

private const val MAX_COUNTER = 3

@Composable
fun SplashRoute(
    modifier: Modifier = Modifier,
    onNavigateToMainScreen: () -> Unit = {},
) {
    SplashScreen(
        modifier = modifier,
        onNavigateToMainScreen = onNavigateToMainScreen
    )
}

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToMainScreen: () -> Unit = {},
) {
    var counter by remember { mutableIntStateOf(0) }

    val counterText = stringResource(R.string.text_splash_loading) + ".".repeat(counter)

    LaunchedEffect(key1 = Unit) {
        repeat(MAX_COUNTER) {
            delay(AppConstant.TIME_TASK_DELAYED)
            counter++
        }

        //Navigate to Main Screen
        onNavigateToMainScreen()
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                color = MaterialTheme.customColorsPalette.primaryColor
            )
            .fillMaxSize(),
    ) {
        NinePatchImage(
            context = LocalContext.current,
            ninePatchRes = R.drawable.image_splash_banner,
            modifier = Modifier.size(240.dp, 240.dp)
        )

        CircularProgressIndicator(
            modifier = Modifier.padding(top = 50.dp),
            color = colorResource(R.color.white),
        )

        Text(
            text = counterText,
            style = MaterialTheme.customFontStyle.textStyleNormal.copy(
                color = colorResource(R.color.white)
            ),
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}

@DarkLightPreview
@Composable
private fun PreviewSplashScreen() {
    MotorbikeDriverLicenseAppTheme {
        SplashScreen()
    }
}