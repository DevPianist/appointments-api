package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class Candidate(
    val id: String,
    val fullName: String,
)
