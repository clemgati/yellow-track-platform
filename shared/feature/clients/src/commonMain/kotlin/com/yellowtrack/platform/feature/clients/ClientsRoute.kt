package com.yellowtrack.platform.feature.clients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.yellowtrack.platform.feature.clients.data.InMemoryClientRepository
import com.yellowtrack.platform.feature.clients.presentation.ClientsScreen
import com.yellowtrack.platform.feature.clients.presentation.ClientsViewModel

@Composable
fun ClientsRoute(modifier: Modifier = Modifier) {
    val viewModel =
        remember {
            ClientsViewModel(
                clientRepository = InMemoryClientRepository(),
            )
        }

    val uiState by viewModel.uiState.collectAsState()

    ClientsScreen(
        uiState = uiState,
        onRetry = viewModel::retry,
        onClientSelected = { clientId ->
            // YTP-013B: navigate to Client Details.
        },
        modifier = modifier,
    )
}
