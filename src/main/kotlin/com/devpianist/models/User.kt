package com.devpianist.models

import com.servall.models.Role
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class User(
    val id: String,
    @Transient val userName: String = "",
    val fullName: String,
    @Transient val password: String? = null,
    val token: String,
    val role: Role,
)
