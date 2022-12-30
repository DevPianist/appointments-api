package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class JobDescription(
    val id: String,
    val description: String,
    val englishRequired: Boolean,
    val client: Client,
    val recruiter: User,
)
