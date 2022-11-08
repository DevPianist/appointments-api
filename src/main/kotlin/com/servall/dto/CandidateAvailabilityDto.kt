package com.servall.dto

data class CandidateAvailabilityDto(
    val weekDayRange: String,
    val hourRange: String,
    val skills: List<String>
)
