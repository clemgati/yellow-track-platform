package com.yellowtrack.platform.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Stable
class AppState(
    initialDestination: AppDestination = AppDestination.Dashboard,
) {
    var currentDestination by mutableStateOf(initialDestination)
        private set

    fun navigateTopLevel(destination: AppDestination) {
        if (destination == currentDestination) return

        currentDestination = destination
    }
}

@Composable
fun rememberAppState(initialDestination: AppDestination = AppDestination.Dashboard): AppState =
    remember(initialDestination) {
        AppState(
            initialDestination = initialDestination,
        )
    }
