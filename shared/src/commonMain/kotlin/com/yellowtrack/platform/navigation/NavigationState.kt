package com.yellowtrack.platform.navigation

data class NavigationState<D : Destination>(
    val backStack: List<D>,
) {
    init {
        require(backStack.isNotEmpty()) {
            "Navigation back stack must never be empty."
        }
    }

    val current: D
        get() = backStack.last()

    val canNavigateBack: Boolean
        get() = backStack.size > 1
}
