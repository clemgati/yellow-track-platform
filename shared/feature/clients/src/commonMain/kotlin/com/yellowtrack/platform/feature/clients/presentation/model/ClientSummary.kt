package com.yellowtrack.platform.feature.clients.presentation.model

import com.yellowtrack.platform.core.model.client.ClientId

internal data class ClientSummary(
    val id: ClientId,
    val displayName: String,
)
