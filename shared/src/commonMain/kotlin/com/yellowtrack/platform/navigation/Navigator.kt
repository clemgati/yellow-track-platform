package com.yellowtrack.platform.navigation

class Navigator<D : Destination>(
    startDestination: D,
) {
    private var currentState =
        NavigationState(
            backStack = listOf(startDestination),
        )

    val state: NavigationState<D>
        get() = currentState

    fun navigate(destination: D) {
        if (destination == currentState.current) {
            return
        }

        currentState =
            currentState.copy(
                backStack = currentState.backStack + destination,
            )
    }

    fun navigateTopLevel(destination: D) {
        reset(destination)
    }

    fun replace(destination: D) {
        currentState =
            currentState.copy(
                backStack =
                    currentState.backStack
                        .dropLast(1)
                        .plus(destination),
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

    fun reset(destination: D) {
        currentState =
            NavigationState(
                backStack = listOf(destination),
            )
    }
}
