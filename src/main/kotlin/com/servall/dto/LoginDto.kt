package com.servall.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginDto(
    val password: String,
    val userName: String
)
