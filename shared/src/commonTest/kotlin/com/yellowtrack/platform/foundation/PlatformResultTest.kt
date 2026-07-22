package com.yellowtrack.platform.foundation

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class PlatformResultTest {
    @Test
    fun mapTransformsSuccessfulValue() {
        val result =
            PlatformResult
                .Success(2)
                .map { value -> value * 3 }

        val success = assertIs<PlatformResult.Success<Int>>(result)
        assertEquals(6, success.value)
    }

    @Test
    fun mapPreservesFailure() {
        val error =
            PlatformError(
                code = "test_failure",
                message = "Expected failure",
            )

        val result =
            PlatformResult
                .Failure(error)
                .map { value: Int -> value * 3 }

        val failure = assertIs<PlatformResult.Failure>(result)
        assertEquals(error, failure.error)
    }
}
