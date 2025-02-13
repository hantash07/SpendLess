package com.hantash.spendless.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary,

    background = Background,
    surface = Surface,
    onPrimary = OnPrimary,
    onSecondary = OnSecondaryContainer,
    onTertiary = Tertiary,
    onBackground = OnBackground,
    onSurface = OnSurface,
    error = Error,
    onError = OnError,
)

@Composable
fun SpendLessAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}