package com.sid.agronear.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sid.agronear.Api.TokenManager
import com.sid.agronear.repostiory.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = AuthRepository(getApplication())

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                Log.d("AUTH", "Login called for $email")

                val res = repo.login(email, password)
                Log.d("AUTH", "Login response code = ${res.code()}")

                if (res.isSuccessful) {
                    val tokens = res.body()!!
                    Log.d("AUTH", "Login success, saving tokens")
                    TokenManager.saveTokens(tokens.accessToken, tokens.refreshToken)
                    _loginSuccess.value = true
                } else {
                    Log.d("AUTH", "Login failed: ${res.errorBody()?.string()}")
                    _error.value = "Invalid credentials"
                }
            } catch (e: Exception) {
                Log.e("AUTH", "Login exception", e)
                _error.value = e.message
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                Log.d("AUTH", "Register called for $email")

                val res = repo.register(name, email, password)
                Log.d("AUTH", "Register response code = ${res.code()}")

                if (res.isSuccessful) {
                    Log.d("AUTH", "Register success")
                    _loginSuccess.value = true   // means "navigate"
                } else {
                    Log.d("AUTH", "Register failed: ${res.errorBody()?.string()}")
                    _error.value = "User already exists or invalid data"
                }

            } catch (e: Exception) {
                Log.e("AUTH", "Register exception", e)
                _error.value = e.message
            }
        }
    }
}
