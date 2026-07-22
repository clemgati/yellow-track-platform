package com.yellowtrack.platform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.designsystem.YTSTheme
import com.yellowtrack.platform.designsystem.YellowTrackTheme
import com.yellowtrack.platform.designsystem.components.YTSBadge
import com.yellowtrack.platform.designsystem.components.YTSMetricCard
import com.yellowtrack.platform.designsystem.components.YTSPrimaryButton
import com.yellowtrack.platform.designsystem.components.YTSSecondaryButton

@Composable
fun App() {
    YellowTrackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(YTSTheme.spacing.extraLarge),
                verticalArrangement =
                    Arrangement.spacedBy(
                        YTSTheme.spacing.large,
                    ),
            ) {
                YTSBadge(text = "0.1.0 Genesis")

                Text(
                    text = "Yellow Track Platform",
                    style = MaterialTheme.typography.headlineLarge,
                )

                Text(
                    text = "Cross-platform software for photographers.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.spacedBy(
                            YTSTheme.spacing.medium,
                        ),
                ) {
                    YTSMetricCard(
                        label = "Clients",
                        value = "0",
                        modifier = Modifier.weight(1f),
                    )

                    YTSMetricCard(
                        label = "Sessions",
                        value = "0",
                        modifier = Modifier.weight(1f),
                    )

                    YTSMetricCard(
                        label = "Deliveries",
                        value = "0",
                        modifier = Modifier.weight(1f),
                    )
                }

                Row(
                    horizontalArrangement =
                        Arrangement.spacedBy(
                            YTSTheme.spacing.medium,
                        ),
                ) {
                    YTSPrimaryButton(
                        text = "Begin",
                        onClick = {},
                    )

                    YTSSecondaryButton(
                        text = "Documentation",
                        onClick = {},
                    )
                }
            }
        }
    }
}
