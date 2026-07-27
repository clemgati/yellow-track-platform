package com.yellowtrack.platform.feature.clients.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.core.designsystem.component.YTBadge
import com.yellowtrack.platform.core.designsystem.component.YTSectionCard
import com.yellowtrack.platform.core.designsystem.theme.YTTheme
import com.yellowtrack.platform.core.ui.component.EmptyContent
import com.yellowtrack.platform.core.ui.component.StatefulContent
import com.yellowtrack.platform.feature.clients.presentation.component.ClientSummaryRow
import com.yellowtrack.platform.feature.clients.presentation.model.ClientSummary

@Composable
internal fun ClientsScreen(
    uiState: ClientsUiState,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    StatefulContent(
        state = uiState.clients,
        modifier = modifier.fillMaxSize(),
        onRetry = onRetry,
        emptyContent = { emptyModifier ->
            ClientsEmptyContent(
                modifier = emptyModifier,
            )
        },
    ) { clients, contentModifier ->
        ClientsContent(
            clients = clients,
            modifier = contentModifier,
        )
    }
}

@Composable
private fun ClientsContent(
    clients: List<ClientSummary>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(YTTheme.spacing.extraLarge),
        verticalArrangement =
            Arrangement.spacedBy(
                YTTheme.spacing.large,
            ),
    ) {
        ClientsHeader()

        YTSectionCard(
            title = "All Clients",
            modifier = Modifier.fillMaxWidth(),
        ) {
            clients.forEach { client ->
                ClientSummaryRow(
                    client = client,
                )
            }
        }
    }
}

@Composable
private fun ClientsHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement =
            Arrangement.spacedBy(
                YTTheme.spacing.small,
            ),
    ) {
        YTBadge(
            text = "Clients",
        )

        Text(
            text = "Clients",
            style = YTTheme.typography.headlineLarge,
            color = YTTheme.colors.onBackground,
        )

        Text(
            text = "Manage client profiles, contact details, preferences, and session history.",
            style = YTTheme.typography.bodyLarge,
            color = YTTheme.colors.onSurfaceVariant,
        )
    }
}

@Composable
private fun ClientsEmptyContent(modifier: Modifier = Modifier) {
    EmptyContent(
        modifier = modifier,
        title = "No clients yet",
        message = "Your clients will appear here after you add the first one.",
    )
}
