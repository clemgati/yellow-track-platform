package com.yellowtrack.platform.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object YTSTheme {
    val colors
        @Composable
        get() = MaterialTheme.colorScheme

    val typography
        @Composable
        get() = MaterialTheme.typography

    val shapes
        @Composable
        get() = MaterialTheme.shapes

    val spacing
        @Composable
        get() = LocalYTSSpacing.current
}

@Composable
fun YellowTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalYTSSpacing provides YTSSpacing(),
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) YTSDarkColorScheme else YTSLightColorScheme,
            typography = YTSTypography,
            shapes = YTSShapes,
            content = content,
        )
    }
}
