package com.sid.agronear.DataClasses

data class WishlistResponse(
    val productId: Long,
    val productName: String,
    val productPrice: Int,
    val productImage: String,
    val userName: String
)

