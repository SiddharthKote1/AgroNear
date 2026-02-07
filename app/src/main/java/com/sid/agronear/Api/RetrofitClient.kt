package com.sid.agronear.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.content.Context

object RetrofitClient {

    fun create(context: Context): ApiService {

        TokenManager.init(context)

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val token = TokenManager.getAccessToken()

                val request = if (token != null) {
                    chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $token")
                        .build()
                } else {
                    chain.request()
                }

                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8083/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
