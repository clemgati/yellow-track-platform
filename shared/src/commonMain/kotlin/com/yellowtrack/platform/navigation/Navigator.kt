package com.yellowtrack.platform.navigation

class Navigator(
    startDestination: Destination,
) {
    private var currentState =
        NavigationState(
            backStack = listOf(startDestination),
        )

    val state: NavigationState
        get() = currentState

    fun navigate(destination: Destination) {
        if (destination == currentState.current) {
            return
        }

        currentState =
            currentState.copy(
                backStack = currentState.backStack + destination,
            )
    }

    fun navigateTopLevel(destination: Destination) {
        reset(destination)
    }

    fun replace(destination: Destination) {
        val updatedBackStack =
            currentState.backStack
                .dropLast(1)
                .plus(destination)

        currentState =
            currentState.copy(
                backStack = updatedBackStack,
            )
    }

    fun back() {
        if (!currentState.canNavigateBack) {
            return
        }

        currentState =
            currentState.copy(
                backStack = currentState.backStack.dropLast(1),
            )
    }

    fun reset(destination: Destination) {
        currentState =
            NavigationState(
                backStack = listOf(destination),
            )
    }
}
