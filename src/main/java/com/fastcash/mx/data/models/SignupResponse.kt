package com.fastcash.mx.data.models  // Coloca este archivo en el paquete adecuado

data class User(
    val email: String
)
data class SignupResponse(
    val token: String,
    val user: User,
)
//data class SignupResponse(
//    val success: Boolean,
//    val message: String,
//    val userId: String
//)
