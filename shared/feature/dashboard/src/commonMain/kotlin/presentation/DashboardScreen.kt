package com.yellowtrack.platform.feature.dashboard.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.core.designsystem.component.YTBadge
import com.yellowtrack.platform.core.designsystem.component.YTCard
import com.yellowtrack.platform.core.designsystem.theme.YTTheme
import com.yellowtrack.platform.core.ui.component.EmptyContent
import com.yellowtrack.platform.core.ui.component.StatefulContent
import com.yellowtrack.platform.core.ui.state.UiState

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: UiState<DashboardSummary> =
        UiState.Success(
            DashboardSummary(
                upcomingSessions = 0,
                activeClients = 0,
                studioReady = true,
            ),
        ),
    onRetry: () -> Unit = {},
) {
    StatefulContent(
        state = state,
        modifier = modifier.fillMaxSize(),
        onRetry = onRetry,
        emptyContent = { emptyModifier ->
            DashboardEmptyContent(
                modifier = emptyModifier,
            )
        },
    ) { summary, contentModifier ->
        DashboardContent(
            summary = summary,
            modifier = contentModifier,
        )
    }
}

@Composable
private fun DashboardContent(
    summary: DashboardSummary,
    modifier: Modifier = Modifier,
) {
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

        YTCard(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Upcoming sessions: ${summary.upcomingSessions}",
                style = YTTheme.typography.bodyLarge,
            )

            Text(
                text = "Active clients: ${summary.activeClients}",
                style = YTTheme.typography.bodyLarge,
            )

            Text(
                text =
                    if (summary.studioReady) {
                        "Studio status: Ready"
                    } else {
                        "Studio status: Needs attention"
                    },
                style = YTTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
private fun DashboardEmptyContent(modifier: Modifier = Modifier) {
    EmptyContent(
        modifier = modifier,
        title = "No dashboard activity yet",
        message = "Your sessions, clients, and studio updates will appear here.",
    )
}
