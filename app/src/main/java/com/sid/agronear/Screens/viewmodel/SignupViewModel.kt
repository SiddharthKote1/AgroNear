package com.sid.agronear.Screens.viewmodel

import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.DataClasses.RegisterRequest
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var signupSuccess by mutableStateOf(false)
        private set

    fun signup(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (password != confirmPassword) {
            errorMessage = "Passwords do not match"
            return
        }

        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null

                RetrofitClient.api.register(
                    RegisterRequest(
                        name = name,
                        email = email,
                        password = password
                    )
                )

                signupSuccess = true   // ✅ UI observes this

            } catch (e: Exception) {
                errorMessage = "Signup failed. Email may already exist."
            } finally {
                isLoading = false
            }
        }
    }
}
