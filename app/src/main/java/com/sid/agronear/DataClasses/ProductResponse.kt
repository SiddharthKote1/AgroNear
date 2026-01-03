package com.sid.agronear.DataClasses

data class ProductResponse(
    val id: Long,
    val productName: String,
    val productPrice: Int,
    val imageProduct: String,
    val userName: String
)
