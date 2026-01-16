package com.sid.agronear.model

data class WishlistDto(
    val id: Long,
    val userId: Long,
    val product: ProductDto
)
