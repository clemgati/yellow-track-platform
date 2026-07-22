package com.yellowtrack.platform.app

import kotlin.test.Test
import kotlin.test.assertEquals

class AppStateTest {
    @Test
    fun initialDestinationIsDashboard() {
        val state =
            AppState(
                initialDestination = AppDestination.Dashboard,
            )

        assertEquals(
            AppDestination.Dashboard,
            state.currentDestination,
        )
    }

    @Test
    fun navigateToChangesCurrentDestination() {
        val state =
            AppState(
                initialDestination = AppDestination.Dashboard,
            )

        state.navigateTo(AppDestination.Clients)

        assertEquals(
            AppDestination.Clients,
            state.currentDestination,
        )
    }
}
