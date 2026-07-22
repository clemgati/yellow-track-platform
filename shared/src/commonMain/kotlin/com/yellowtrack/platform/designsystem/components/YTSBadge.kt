package com.yellowtrack.platform.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.designsystem.YTSTheme

@Composable
fun YTSBadge(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier =
            modifier
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = YTSTheme.shapes.extraLarge,
                ).padding(
                    horizontal = YTSTheme.spacing.medium,
                    vertical = YTSTheme.spacing.extraSmall,
                ),
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        style = MaterialTheme.typography.labelMedium,
    )
}
