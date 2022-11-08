package com.servall.models

import kotlinx.serialization.Serializable

@Serializable
data class Appointment(
    val id: String,
    val datetime: Long,
    val barberId: String,
    val clientId: String
)
