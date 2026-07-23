package com.yellowtrack.platform.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.yellowtrack.platform.navigation.Navigator

@Immutable
class AppState internal constructor(
    initialDestination: AppDestination,
) {
    private val navigator =
        Navigator(
            startDestination = initialDestination,
        )

    var navigationState by mutableStateOf(navigator.state)
        private set

    val currentDestination: AppDestination
        get() = navigationState.current

    val canNavigateBack: Boolean
        get() = navigationState.canNavigateBack

    fun navigateTo(destination: AppDestination) {
        navigator.navigate(destination)
        synchronizeState()
    }

    fun navigateTopLevel(destination: AppDestination) {
        navigator.navigateTopLevel(destination)
        synchronizeState()
    }

    fun navigateBack() {
        navigator.back()
        synchronizeState()
    }

    fun replace(destination: AppDestination) {
        navigator.replace(destination)
        synchronizeState()
    }

    fun reset(destination: AppDestination) {
        navigator.reset(destination)
        synchronizeState()
    }

    private fun synchronizeState() {
        navigationState = navigator.state
    }
}

@Composable
fun rememberAppState(initialDestination: AppDestination = AppDestination.Dashboard): AppState =
    remember(initialDestination) {
        AppState(initialDestination)
    }
