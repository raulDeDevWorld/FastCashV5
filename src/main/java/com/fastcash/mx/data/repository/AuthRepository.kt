package com.fastcash.mx.data.repository

import com.fastcash.mx.data.api.ApiService
import com.fastcash.mx.data.api.SignupRequest
import com.fastcash.mx.data.models.SignupResponse

class AuthRepository(private val apiService: ApiService) {

    suspend fun signup(email: String, password: String, name: String): SignupResponse {
        val request = SignupRequest(email, password, name)
        return apiService.signup(request).body() ?: throw Exception("Empty response from server")
    }
}
