package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.model.CustomFontStyle

val ComfortaaFontFamily = FontFamily(
    Font(R.font.comfortaa_light, FontWeight.Light),
    Font(R.font.comfortaa_regular, FontWeight.Normal),
    Font(R.font.comfortaa_medium, FontWeight.Medium),
    Font(R.font.comfortaa_semi_bold, FontWeight.SemiBold),
    Font(R.font.comfortaa_bold, FontWeight.Bold),
)

val LocalTextStyles = staticCompositionLocalOf { CustomFontStyle() }