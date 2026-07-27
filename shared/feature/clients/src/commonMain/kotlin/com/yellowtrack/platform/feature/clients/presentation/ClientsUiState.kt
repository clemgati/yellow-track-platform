package com.yellowtrack.platform.feature.clients.presentation

import com.yellowtrack.platform.core.ui.state.UiState
import com.yellowtrack.platform.feature.clients.presentation.model.ClientSummary

internal data class ClientsUiState(
    val clients: UiState<List<ClientSummary>>,
)
