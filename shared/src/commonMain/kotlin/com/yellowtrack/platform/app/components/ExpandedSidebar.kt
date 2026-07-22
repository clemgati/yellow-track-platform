package com.yellowtrack.platform.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yellowtrack.platform.app.AppDestination
import com.yellowtrack.platform.designsystem.YTSTheme
import com.yellowtrack.platform.designsystem.components.YTSBadge

@Composable
fun ExpandedSidebar(
    currentDestination: AppDestination,
    onDestinationSelected: (AppDestination) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .width(SidebarWidth)
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surface)
                .padding(YTSTheme.spacing.large),
        verticalArrangement = Arrangement.spacedBy(YTSTheme.spacing.small),
    ) {
        Text(
            text = "Yellow Track",
            style = MaterialTheme.typography.titleLarge,
        )

        YTSBadge(text = "Genesis")

        Spacer(modifier = Modifier.padding(top = YTSTheme.spacing.medium))

        AppDestination.entries.forEach { destination ->
            SidebarDestination(
                destination = destination,
                selected = destination == currentDestination,
                onClick = {
                    onDestinationSelected(destination)
                },
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "0.1.0",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
private fun SidebarDestination(
    destination: AppDestination,
    selected: Boolean,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = YTSTheme.shapes.medium,
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = YTSTheme.spacing.small,
                        vertical = YTSTheme.spacing.extraSmall,
                    ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.spacedBy(
                    YTSTheme.spacing.medium,
                ),
        ) {
            Text(
                text = destination.symbol,
                color =
                    if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
            )

            Text(
                text = destination.label,
                color =
                    if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    },
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

private val SidebarWidth = 240.dp
