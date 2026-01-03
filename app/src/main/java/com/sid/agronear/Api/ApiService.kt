package com.sid.agronear.Api

import com.sid.agronear.DataClasses.LoginRequest
import com.sid.agronear.DataClasses.LoginResponse
import com.sid.agronear.DataClasses.ProductResponse
import com.sid.agronear.DataClasses.RegisterRequest
import com.sid.agronear.DataClasses.WishlistResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {


    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest)

    @GET("products")
    suspend fun getProducts(): List<ProductResponse>

    @POST("wishlist/{id}")
    suspend fun addToWishlist(@Path("id") id: Long)

    @GET("wishlist")
    suspend fun getWishlist(): List<WishlistResponse>

    @Multipart
    @POST("products")
    suspend fun addProduct(
        @Part("productName") productName: RequestBody,
        @Part("productPrice") productPrice: RequestBody,
        @Part image: MultipartBody.Part
    )

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Long
    ): ProductResponse


    @DELETE("wishlist/{productId}")
    suspend fun removeFromWishlist(
        @Path("productId") productId: Long
    )

}

