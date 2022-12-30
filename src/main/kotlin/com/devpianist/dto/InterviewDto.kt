package com.devpianist.dto

import kotlinx.serialization.Serializable

@Serializable
data class InterviewDto(
    val dateTime: Long,
    val interviewerId: String,
    val jobDescriptionId: String,
    val candidateId: String,
)