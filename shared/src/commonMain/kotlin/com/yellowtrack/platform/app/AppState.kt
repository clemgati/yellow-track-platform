package com.yellowtrack.platform.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Immutable
class AppState internal constructor(
    initialDestination: AppDestination,
) {
    var currentDestination by mutableStateOf(initialDestination)
        private set

    fun navigateTo(destination: AppDestination) {
        currentDestination = destination
    }
}

@Composable
fun rememberAppState(initialDestination: AppDestination = AppDestination.Dashboard): AppState =
    remember(initialDestination) {
        AppState(initialDestination)
    }
