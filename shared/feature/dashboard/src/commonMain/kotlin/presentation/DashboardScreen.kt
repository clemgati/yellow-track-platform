package com.yellowtrack.platform.feature.dashboard.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.core.designsystem.component.YTBadge
import com.yellowtrack.platform.core.designsystem.component.YTCard
import com.yellowtrack.platform.core.designsystem.theme.YTTheme

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(YTTheme.spacing.extraLarge),
        verticalArrangement =
            Arrangement.spacedBy(
                YTTheme.spacing.large,
            ),
    ) {
        YTBadge(
            text = "Genesis",
        )

        Text(
            text = "Dashboard",
            style = YTTheme.typography.headlineLarge,
            color = YTTheme.colors.onBackground,
        )

        YTCard {
            Text(
                text = "Your daily studio overview, upcoming work, and important actions.",
                style = YTTheme.typography.bodyLarge,
            )
        }
    }
}
