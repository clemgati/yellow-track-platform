package com.yellowtrack.platform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.app.AppShell
import com.yellowtrack.platform.app.rememberAppState
import com.yellowtrack.platform.designsystem.YellowTrackTheme

@Composable
fun App() {
    YellowTrackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            AppShell(
                appState = rememberAppState(),
            )
        }
    }
}
