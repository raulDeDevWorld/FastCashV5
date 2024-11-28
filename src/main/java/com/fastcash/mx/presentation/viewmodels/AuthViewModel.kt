package com.fastcash.mx.presentation.viewmodels


import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.fastcash.mx.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _signupState = MutableStateFlow<SignupState>(SignupState.Idle)
    val signupState = _signupState.asStateFlow()

    fun signup(email: String, password: String, nombreCompleto: String) {
        _signupState.value = SignupState.Loading

        viewModelScope.launch {
            try {
                val response = repository.signup(email, password, nombreCompleto)
                if (response.token !== null) {
                    _signupState.value = SignupState.Success(response.user.email ?: "")
                } else {
                    _signupState.value = SignupState.Error(response.token ?: "Signup failed")
                }
            } catch (e: HttpException) {
                _signupState.value = SignupState.Error("Server error: ${e.message}")
            } catch (e: IOException) {
                _signupState.value = SignupState.Error("Network error: ${e.message}")
            } catch (e: Exception) {
                _signupState.value = SignupState.Error("Unexpected error: ${e.message}")
            }
        }
    }
}

sealed class SignupState {
    object Idle : SignupState()
    object Loading : SignupState()
    data class Success(val userId: String) : SignupState()
    data class Error(val message: String) : SignupState()
}
