package com.yellowtrack.platform.feature.clients.data

import com.yellowtrack.platform.core.model.client.Client
import com.yellowtrack.platform.core.model.client.ClientId
import com.yellowtrack.platform.feature.clients.domain.ClientRepository

internal class InMemoryClientRepository : ClientRepository {
    override suspend fun getClients(): List<Client> =
        listOf(
            Client(
                id = ClientId("1"),
                firstName = "John",
                lastName = "Smith",
            ),
            Client(
                id = ClientId("2"),
                firstName = "Sarah",
                lastName = "Johnson",
            ),
            Client(
                id = ClientId("3"),
                firstName = "Emily",
                lastName = "Davis",
            ),
            Client(
                id = ClientId("4"),
                firstName = "Michael",
                lastName = "Brown",
            ),
        )
}
