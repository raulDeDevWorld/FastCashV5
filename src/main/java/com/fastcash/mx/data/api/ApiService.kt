package com.fastcash.mx.data.api
import com.fastcash.mx.data.models.LoginResponse
import com.fastcash.mx.data.models.SignupResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// Modelo de datos para la solicitud y respuesta de registro
data class LoginRequest(val email: String, val password: String)
data class SignupRequest(val email: String, val password: String, val nombreCompleto: String)

// Interfaz de la API
interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("auth/registerPersonal/")
    suspend fun signup(@Body request: SignupRequest): Response<SignupResponse>
}
