package com.fastcash.mx.data.models

data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val message: String?
)
