package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.customColorsPalette

@Immutable
data class CustomFontStyle(
    val fontFamily: FontFamily = FontFamily.Default,
) {
    val textStyleLight: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.customColorsPalette.primaryTextColor,
        )

    val textStyleNormal: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.customColorsPalette.primaryTextColor,
        )

    val textStyleMedium: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.customColorsPalette.primaryTextColor,
        )

    val textStyleSemiBold: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.customColorsPalette.primaryTextColor,
        )

    val textStyleBold: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.customColorsPalette.primaryTextColor,
        )
}