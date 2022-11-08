package com.servall.models

import kotlinx.serialization.Serializable

@Serializable
data class Candidate(
    val id: String,
    val fullName: String,
    val requiredSkills: List<Skill>,
    val client: String,
    val englishRequired: Boolean,
    val weekDayRange: String,
    val hourRange: String,
)
