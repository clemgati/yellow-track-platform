package com.yellowtrack.platform.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.app.AppDestination
import com.yellowtrack.platform.designsystem.YTSTheme
import com.yellowtrack.platform.designsystem.components.YTSBadge
import com.yellowtrack.platform.designsystem.components.YTSCard

@Composable
fun PlaceholderScreen(
    destination: AppDestination,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(YTSTheme.spacing.extraLarge),
        verticalArrangement =
            Arrangement.spacedBy(
                YTSTheme.spacing.large,
            ),
        horizontalAlignment = Alignment.Start,
    ) {
        YTSBadge(text = "Coming soon")

        Text(
            text = destination.label,
            style = MaterialTheme.typography.headlineLarge,
        )

        YTSCard {
            Text(
                text = destinationDescription(destination),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

private fun destinationDescription(destination: AppDestination): String =
    when (destination) {
        AppDestination.Dashboard ->
            "Your daily studio overview, upcoming work, and important actions."

        AppDestination.Clients ->
            "Client profiles, preferences, permissions, and session history."

        AppDestination.Sessions ->
            "Plan and track photography sessions from preparation through delivery."

        AppDestination.Studio ->
            "Manage gear, lighting recipes, backdrops, batteries, and studio readiness."

        AppDestination.Settings ->
            "Configure Yellow Track Platform and platform-specific integrations."
    }
