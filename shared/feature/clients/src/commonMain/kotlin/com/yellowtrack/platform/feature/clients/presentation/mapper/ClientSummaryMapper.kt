package com.yellowtrack.platform.feature.clients.presentation.mapper

import com.yellowtrack.platform.core.model.client.Client
import com.yellowtrack.platform.feature.clients.presentation.model.ClientSummary

internal fun List<Client>.toClientSummaries(): List<ClientSummary> = map(Client::toClientSummary)

private fun Client.toClientSummary() =
    ClientSummary(
        id = id,
        displayName = displayName,
    )
