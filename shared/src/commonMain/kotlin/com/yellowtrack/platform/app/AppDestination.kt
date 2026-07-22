package com.yellowtrack.platform.app

enum class AppDestination(
    val label: String,
    val symbol: String,
) {
    Dashboard(
        label = "Dashboard",
        symbol = "D",
    ),
    Clients(
        label = "Clients",
        symbol = "C",
    ),
    Sessions(
        label = "Sessions",
        symbol = "S",
    ),
    Studio(
        label = "Studio",
        symbol = "ST",
    ),
    Settings(
        label = "Settings",
        symbol = "⚙",
    ),
}
