package com.yellowtrack.platform.app

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yellowtrack.platform.app.components.CompactNavigationBar
import com.yellowtrack.platform.app.components.ExpandedSidebar
import com.yellowtrack.platform.core.designsystem.component.YTScaffold
import com.yellowtrack.platform.core.designsystem.theme.YTTheme
import com.yellowtrack.platform.feature.clients.ClientsRoute
import com.yellowtrack.platform.feature.dashboard.DashboardRoute
import com.yellowtrack.platform.feature.sessions.presentation.SessionsScreen
import com.yellowtrack.platform.feature.settings.presentation.SettingsScreen
import com.yellowtrack.platform.feature.studio.presentation.StudioScreen

@Composable
fun AppShell(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
    ) {
        val useExpandedNavigation =
            maxWidth >= ExpandedNavigationBreakpoint

        if (useExpandedNavigation) {
            ExpandedAppShell(
                appState = appState,
            )
        } else {
            CompactAppShell(
                appState = appState,
            )
        }
    }
}

@Composable
private fun ExpandedAppShell(appState: AppState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = YTTheme.colors.background,
        contentColor = YTTheme.colors.onBackground,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            ExpandedSidebar(
                currentDestination = appState.currentDestination,
                onDestinationSelected = appState::navigateTopLevel,
            )
            CurrentDestination(
                destination = appState.currentDestination,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun CompactAppShell(appState: AppState) {
    YTScaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            CompactNavigationBar(
                currentDestination = appState.currentDestination,
                onDestinationSelected = appState::navigateTopLevel,
            )
        },
    ) { contentPadding ->
        CurrentDestination(
            destination = appState.currentDestination,
            modifier = Modifier.padding(contentPadding),
        )
    }
}

@Composable
private fun CurrentDestination(
    destination: AppDestination,
    modifier: Modifier = Modifier,
) {
    when (destination) {
        AppDestination.Dashboard ->
            DashboardRoute(
                modifier = modifier,
            )

        AppDestination.Clients ->
            ClientsRoute(
                modifier = modifier,
            )

        AppDestination.Sessions ->
            SessionsScreen(modifier)

        AppDestination.Studio ->
            StudioScreen(modifier)

        AppDestination.Settings ->
            SettingsScreen(modifier)
    }
}

private val ExpandedNavigationBreakpoint = 840.dp
