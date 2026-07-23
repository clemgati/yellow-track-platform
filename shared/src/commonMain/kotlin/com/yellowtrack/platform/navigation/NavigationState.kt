package com.yellowtrack.platform.navigation

data class NavigationState(
    val backStack: List<Destination>,
) {
    init {
        require(backStack.isNotEmpty()) {
            "Navigation back stack must never be empty."
        }
    }

    val current: Destination
        get() = backStack.last()

    val canNavigateBack: Boolean
        get() = backStack.size > 1
}
