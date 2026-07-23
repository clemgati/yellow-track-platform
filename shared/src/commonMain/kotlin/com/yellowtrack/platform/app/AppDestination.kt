package com.yellowtrack.platform.app

import com.yellowtrack.platform.navigation.Destination

enum class AppDestination(
    override val route: String,
    val label: String,
    val symbol: String,
) : Destination {
    Dashboard(
        route = "dashboard",
        label = "Dashboard",
        symbol = "D",
    ),
    Clients(
        route = "clients",
        label = "Clients",
        symbol = "C",
    ),
    Sessions(
        route = "sessions",
        label = "Sessions",
        symbol = "S",
    ),
    Studio(
        route = "studio",
        label = "Studio",
        symbol = "ST",
    ),
    Settings(
        route = "settings",
        label = "Settings",
        symbol = "⚙",
    ),
}
