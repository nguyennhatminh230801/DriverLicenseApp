package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.MotorbikeDriverLicenseAppTheme

class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val appState = rememberAppState(context = context)

            BackHandler {
                if (appState.isFinish) {
                    finish()
                }
            }

            MotorbikeDriverLicenseAppTheme {
                AppNavHost(
                    appState = appState,
                )
            }
        }
    }
}