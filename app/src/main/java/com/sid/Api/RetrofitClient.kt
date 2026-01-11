package com.sid.Api

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:8082/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)
}