package com.sid.agronear.repostiory

import android.content.Context
import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.model.LoginRequest
import com.sid.agronear.model.RegisterRequest

class AuthRepository(context: Context) {

    private val api = RetrofitClient.create(context)

    suspend fun login(email: String, password: String) =
        api.login(LoginRequest(email, password))

    suspend fun register(name: String, email: String, password: String) =
        api.register(RegisterRequest(name, email, password))
}