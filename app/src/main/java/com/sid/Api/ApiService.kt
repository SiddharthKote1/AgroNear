package com.sid.Api


import com.sid.model.LoginRequest
import com.sid.model.ProductDto
import com.sid.model.RegisterRequest
import com.sid.model.TokenPair
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {


    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<Unit>

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<TokenPair>

    @POST("auth/refresh")
    suspend fun refreshToken(
        @Body tokenPair: TokenPair
    ): Response<TokenPair>



    @GET("products")
    suspend fun getAllProducts(): Response<List<ProductDto>>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Long
    ): Response<ProductDto>

    @GET("products/search")
    suspend fun searchProducts(
        @Query("q") query: String
    ): Response<List<ProductDto>>

    @POST("products")
    suspend fun addProduct(
        @Body product: ProductDto
    ): Response<ProductDto>

    @PUT("products/{id}")
    suspend fun updateProduct(
        @Path("id") id: Long,
        @Body product: ProductDto
    ): Response<ProductDto>

    @DELETE("products/{id}")
    suspend fun deleteProduct(
        @Path("id") id: Long
    ): Response<Unit>


    @POST("wishlist/{productId}")
    suspend fun addToWishlist(
        @Path("productId") productId: Long
    ): Response<Unit>

    @DELETE("wishlist/{productId}")
    suspend fun removeFromWishlist(
        @Path("productId") productId: Long
    ): Response<Unit>

    @GET("wishlist")
    suspend fun getWishlist(): Response<List<ProductDto>>
}
