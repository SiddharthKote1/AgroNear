package com.sid.agronear.model

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val id: Long,
    val productName: String,
    val productPrice: Double,
    val quantity: Int,
    val description: String,
    val imageUrl: String,
    val farmerName: String
)