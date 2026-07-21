package com.yellowtrack.platform.foundation

data class PlatformError(
    val code: String,
    val message: String,
    val cause: Throwable? = null,
)
