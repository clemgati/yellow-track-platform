package com.yellowtrack.platform.foundation

sealed interface PlatformResult<out T> {
    data class Success<T>(
        val value: T,
    ) : PlatformResult<T>

    data class Failure(
        val error: PlatformError,
    ) : PlatformResult<Nothing>
}

inline fun <T, R> PlatformResult<T>.map(transform: (T) -> R): PlatformResult<R> =
    when (this) {
        is PlatformResult.Success -> PlatformResult.Success(transform(value))
        is PlatformResult.Failure -> this
    }
