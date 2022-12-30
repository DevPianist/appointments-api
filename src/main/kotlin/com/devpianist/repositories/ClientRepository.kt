package com.devpianist.repositories

import com.devpianist.models.Client

object ClientRepository {

    val clients = mutableListOf<Client>(
        Client(
            id = "1",
            name = "Scotiabank",
            description = "Bank",
        )
    )
}