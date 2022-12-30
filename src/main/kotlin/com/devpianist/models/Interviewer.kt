package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class Interviewer(
    val id: String,
    val weekDayRange: String,
    val hourRange: String,
    val available: Boolean,
    val user: User,
)