package com.yellowtrack.platform.feature.dashboard.presentation

data class DashboardSummary(
    val upcomingSessions: Int,
    val activeClients: Int,
    val studioReady: Boolean,
)
