package com.yellowtrack.platform.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.designsystem.YTSTheme

@Composable
fun YTSMetricCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    YTSCard(modifier = modifier) {
        Column(
            verticalArrangement =
                Arrangement.spacedBy(
                    YTSTheme.spacing.small,
                ),
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
