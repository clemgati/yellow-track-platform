package com.yellowtrack.platform.app

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yellowtrack.platform.app.components.CompactNavigationBar
import com.yellowtrack.platform.app.components.ExpandedSidebar
import com.yellowtrack.platform.app.components.PlaceholderScreen

@Composable
fun AppShell(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
    ) {
        val useExpandedNavigation = maxWidth >= ExpandedNavigationBreakpoint

        if (useExpandedNavigation) {
            ExpandedAppShell(appState = appState)
        } else {
            CompactAppShell(appState = appState)
        }
    }
}

@Composable
private fun ExpandedAppShell(appState: AppState) {
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        ExpandedSidebar(
            currentDestination = appState.currentDestination,
            onDestinationSelected = appState::navigateTopLevel,
        )

        PlaceholderScreen(
            destination = appState.currentDestination,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun CompactAppShell(appState: AppState) {
    Scaffold(
        bottomBar = {
            CompactNavigationBar(
                currentDestination = appState.currentDestination,
                onDestinationSelected = appState::navigateTopLevel,
            )
        },
    ) { contentPadding ->
        PlaceholderScreen(
            destination = appState.currentDestination,
            modifier =
                Modifier.padding(
                    contentPadding,
                ),
        )
    }
}

private val ExpandedNavigationBreakpoint = 840.dp
