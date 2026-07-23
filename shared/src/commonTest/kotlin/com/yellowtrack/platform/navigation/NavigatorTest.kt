package com.yellowtrack.platform.navigation

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NavigatorTest {
    @Test
    fun startsAtInitialDestination() {
        val navigator = Navigator(TestDestination.Dashboard)

        assertEquals(
            TestDestination.Dashboard,
            navigator.state.current,
        )
        assertEquals(
            listOf(TestDestination.Dashboard),
            navigator.state.backStack,
        )
        assertFalse(navigator.state.canNavigateBack)
    }

    @Test
    fun navigatePushesDestinationOntoBackStack() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.navigate(TestDestination.Clients)

        assertEquals(
            listOf(
                TestDestination.Dashboard,
                TestDestination.Clients,
            ),
            navigator.state.backStack,
        )
        assertEquals(
            TestDestination.Clients,
            navigator.state.current,
        )
        assertTrue(navigator.state.canNavigateBack)
    }

    @Test
    fun navigateIgnoresCurrentDestination() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.navigate(TestDestination.Dashboard)

        assertEquals(
            listOf(TestDestination.Dashboard),
            navigator.state.backStack,
        )
    }

    @Test
    fun backReturnsToPreviousDestination() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.navigate(TestDestination.Clients)
        navigator.back()

        assertEquals(
            TestDestination.Dashboard,
            navigator.state.current,
        )
        assertFalse(navigator.state.canNavigateBack)
    }

    @Test
    fun backAtRootDoesNothing() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.back()

        assertEquals(
            listOf(TestDestination.Dashboard),
            navigator.state.backStack,
        )
    }

    @Test
    fun replaceChangesOnlyCurrentDestination() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.navigate(TestDestination.Clients)
        navigator.replace(TestDestination.Sessions)

        assertEquals(
            listOf(
                TestDestination.Dashboard,
                TestDestination.Sessions,
            ),
            navigator.state.backStack,
        )
    }

    @Test
    fun resetClearsBackStack() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.navigate(TestDestination.Clients)
        navigator.navigate(TestDestination.Sessions)
        navigator.reset(TestDestination.Settings)

        assertEquals(
            listOf(TestDestination.Settings),
            navigator.state.backStack,
        )
        assertFalse(navigator.state.canNavigateBack)
    }

    @Test
    fun navigateTopLevelResetsBackStack() {
        val navigator = Navigator(TestDestination.Dashboard)

        navigator.navigate(TestDestination.Clients)
        navigator.navigateTopLevel(TestDestination.Studio)

        assertEquals(
            listOf(TestDestination.Studio),
            navigator.state.backStack,
        )
    }

    private enum class TestDestination(
        override val route: String,
    ) : Destination {
        Dashboard("dashboard"),
        Clients("clients"),
        Sessions("sessions"),
        Studio("studio"),
        Settings("settings"),
    }
}
