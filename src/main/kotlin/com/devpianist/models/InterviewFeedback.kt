package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class InterviewFeedback(
    val id: String,
    val description: String,
    val interview: Interview,
)
