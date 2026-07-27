package com.yellowtrack.platform.feature.clients.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.core.designsystem.component.YTBadge
import com.yellowtrack.platform.core.designsystem.theme.YTTheme
import com.yellowtrack.platform.feature.clients.presentation.model.ClientSummary

@Composable
internal fun ClientSummaryRow(
    client: ClientSummary,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement =
            Arrangement.spacedBy(
                YTTheme.spacing.medium,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YTBadge(
            text = client.displayName,
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement =
                Arrangement.spacedBy(
                    YTTheme.spacing.extraSmall,
                ),
        ) {
            Text(
                text = client.displayName,
                style = YTTheme.typography.titleMedium,
                color = YTTheme.colors.onSurface,
            )
        }
    }
}
