package com.sid.model

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val id: Long,

    @SerializedName("productName")
    val name: String,

    @SerializedName("productPrice")
    val price: Double,

    val quantity: Int,

    @SerializedName("sellerName")
    val farmerName: String
)
