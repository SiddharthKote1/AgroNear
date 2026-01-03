package com.sid.agronear.Screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.Api.TokenManager
import com.sid.agronear.DataClasses.LoginRequest
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class LoginViewModel : ViewModel() {

    // 🔹 UI state
    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    /**
     * 🔐 Login user using backend
     */
    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null

                // 🔹 API call
                val response = RetrofitClient.api.login(
                    LoginRequest(
                        email = email,
                        password = password
                    )
                )

                // 🔹 Save JWT token
                TokenManager.token = response.token

                // 🔹 Navigate to next screen
                onSuccess()

            } catch (e: Exception) {
                errorMessage = "Invalid email or password"
            } finally {
                isLoading = false
            }
        }
    }
}
