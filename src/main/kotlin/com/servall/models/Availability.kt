package com.servall.models

import kotlinx.serialization.Serializable

@Serializable
data class Availability(
    val weekDayRange: String,
    val hourRange: String,
    val available: Boolean,
    val user: User
)
