package com.devpianist.models

import kotlinx.serialization.Serializable

@Serializable
data class JobDescriptionSkill(
    val id: String,
    val description: String,
    val jobDescriptionId: String
)
