package com.yellowtrack.platform.app

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AppStateTest {
    @Test
    fun initialDestinationIsExposed() {
        val state =
            AppState(
                initialDestination = AppDestination.Dashboard,
            )

        assertEquals(
            AppDestination.Dashboard,
            state.currentDestination,
        )
        assertFalse(state.canNavigateBack)
    }

    @Test
    fun navigateToAddsDestinationToHistory() {
        val state =
            AppState(
                initialDestination = AppDestination.Dashboard,
            )

        state.navigateTo(AppDestination.Clients)

        assertEquals(
            AppDestination.Clients,
            state.currentDestination,
        )
        assertTrue(state.canNavigateBack)
    }

    @Test
    fun navigateBackReturnsToPreviousDestination() {
        val state =
            AppState(
                initialDestination = AppDestination.Dashboard,
            )

        state.navigateTo(AppDestination.Clients)
        state.navigateBack()

        assertEquals(
            AppDestination.Dashboard,
            state.currentDestination,
        )
        assertFalse(state.canNavigateBack)
    }

    @Test
    fun topLevelNavigationResetsHistory() {
        val state =
            AppState(
                initialDestination = AppDestination.Dashboard,
            )

        state.navigateTo(AppDestination.Clients)
        state.navigateTopLevel(AppDestination.Settings)

        assertEquals(
            AppDestination.Settings,
            state.currentDestination,
        )
        assertFalse(state.canNavigateBack)
    }
}
