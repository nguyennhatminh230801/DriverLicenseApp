package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.model.CustomColorsPalette
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.ui.theme.model.CustomFontStyle

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }

@Composable
fun MotorbikeDriverLicenseAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val lightCustomColorsPalette = CustomColorsPalette(
        primaryColor = colorResource(R.color.primary_color),
        primaryTextColor = colorResource(R.color.white),
        backgroundColor = Color.White,
    )

    val darkCustomColorsPalette = CustomColorsPalette(
        primaryColor = colorResource(R.color.primary_color),
        primaryTextColor = Color.Black,
        backgroundColor = Color.White,
    )

    // "normal" palette, nothing change here
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColorsPalette  = when {
        darkTheme -> darkCustomColorsPalette
        else -> lightCustomColorsPalette
    }

    val customFontStyle = CustomFontStyle(fontFamily = ComfortaaFontFamily)

    // here is the important point, where you will expose custom objects
    CompositionLocalProvider(
        LocalCustomColorsPalette provides customColorsPalette,
        LocalTextStyles provides customFontStyle, // our custom palette
    ) {
        MaterialTheme(
            colorScheme = colorScheme , // the MaterialTheme still uses the "normal" palette
            content = content
        )
    }
}

val MaterialTheme.customColorsPalette: CustomColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColorsPalette.current

val MaterialTheme.customFontStyle: CustomFontStyle
    @Composable
    @ReadOnlyComposable
    get() = LocalTextStyles.current