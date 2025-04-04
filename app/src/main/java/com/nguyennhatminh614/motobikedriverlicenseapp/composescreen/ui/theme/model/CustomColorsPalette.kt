package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.model

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 * References: Android - Create custom colors in Compose with Material 3.
 * Link: "https://stackoverflow.com/a/77041136"
 */
@Stable
data class CustomColorsPalette(
    //Default color
    val primaryColor: Color = Color.Unspecified,

    //Text color
    val primaryTextColor: Color = Color.Unspecified,

    //Background color
    val backgroundColor: Color = Color.Unspecified,
)

