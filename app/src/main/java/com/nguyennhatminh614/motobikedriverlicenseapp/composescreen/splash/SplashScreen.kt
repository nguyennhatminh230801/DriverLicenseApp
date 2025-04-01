package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.components.NinePatchImage
import com.nguyennhatminh614.motobikedriverlicenseapp.utils.constant.AppConstant
import kotlinx.coroutines.delay

private const val MAX_COUNTER = 3
private const val LOADING = "Đang tải"




@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToMainScreen: () -> Unit = {},
) {
    var counter by remember { mutableIntStateOf(0) }

    val counterText by remember {
        derivedStateOf { LOADING + ".".repeat(counter) }
    }

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
                color = colorResource(R.color.primary_color)
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
            color = colorResource(R.color.white)
        )

        Text(
            text = counterText,
            style = TextStyle(
                color = colorResource(R.color.white),
                fontFamily = FontFamily(Font(R.font.comfortaa_regular))
            ),
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewSplashScreen() {
    SplashScreen()
}