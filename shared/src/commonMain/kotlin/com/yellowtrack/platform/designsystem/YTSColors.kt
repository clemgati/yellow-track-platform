package com.yellowtrack.platform.designsystem

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal val YTSBrandYellow = Color(0xFFFAB91D)
internal val YTSBrandYellowDark = Color(0xFFFFC83D)

internal val YTSBlack = Color(0xFF111111)
internal val YTSNearBlack = Color(0xFF181818)
internal val YTSDarkSurface = Color(0xFF222222)
internal val YTSDarkSurfaceVariant = Color(0xFF303030)

internal val YTSWhite = Color(0xFFFFFFFF)
internal val YTSOffWhite = Color(0xFFF7F7F5)
internal val YTSLightSurface = Color(0xFFFFFFFF)
internal val YTSLightSurfaceVariant = Color(0xFFECECEA)

internal val YTSSuccess = Color(0xFF2E7D32)
internal val YTSWarning = Color(0xFFF57C00)
internal val YTSError = Color(0xFFBA1A1A)

internal val YTSLightColorScheme =
    lightColorScheme(
        primary = YTSBrandYellow,
        onPrimary = YTSBlack,
        primaryContainer = Color(0xFFFFE3A1),
        onPrimaryContainer = YTSBlack,
        secondary = YTSBlack,
        onSecondary = YTSWhite,
        background = YTSOffWhite,
        onBackground = YTSBlack,
        surface = YTSLightSurface,
        onSurface = YTSBlack,
        surfaceVariant = YTSLightSurfaceVariant,
        onSurfaceVariant = Color(0xFF474747),
        error = YTSError,
        onError = YTSWhite,
    )

internal val YTSDarkColorScheme =
    darkColorScheme(
        primary = YTSBrandYellowDark,
        onPrimary = YTSBlack,
        primaryContainer = Color(0xFF5C4300),
        onPrimaryContainer = Color(0xFFFFE3A1),
        secondary = YTSWhite,
        onSecondary = YTSBlack,
        background = YTSNearBlack,
        onBackground = YTSWhite,
        surface = YTSDarkSurface,
        onSurface = YTSWhite,
        surfaceVariant = YTSDarkSurfaceVariant,
        onSurfaceVariant = Color(0xFFD0D0D0),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
    )
