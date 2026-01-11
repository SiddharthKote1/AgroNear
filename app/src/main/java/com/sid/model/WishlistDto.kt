package com.sid.model

data class WishlistDto(
    val id: Long,
    val userId: Long,
    val product: ProductDto
)
