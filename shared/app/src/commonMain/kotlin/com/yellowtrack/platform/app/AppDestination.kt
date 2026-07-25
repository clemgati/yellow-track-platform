package com.yellowtrack.platform.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
) {
    Dashboard(
        route = "dashboard",
        label = "Dashboard",
        icon = Icons.Default.Dashboard,
    ),

    Clients(
        route = "clients",
        label = "Clients",
        icon = Icons.Default.Groups,
    ),

    Sessions(
        route = "sessions",
        label = "Sessions",
        icon = Icons.AutoMirrored.Filled.ListAlt,
    ),

    Studio(
        route = "studio",
        label = "Studio",
        icon = Icons.Default.Storefront,
    ),

    Settings(
        route = "settings",
        label = "Settings",
        icon = Icons.Default.Settings,
    ),
}
