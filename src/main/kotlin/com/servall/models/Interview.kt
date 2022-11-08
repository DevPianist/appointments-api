package com.servall.models

import kotlinx.serialization.Serializable

@Serializable
data class Interview(
    val id: String,
    val date: String,
    val recruiterId: String,
    val interviewerId: String,
    val candidateId: String
)
