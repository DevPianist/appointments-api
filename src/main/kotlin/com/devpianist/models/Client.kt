package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val id: String,
    val name: String,
    val description: String
)
