package com.sid.agronear.model

data class UserDto(
    val id: Long,
    val name: String,
    val email: String,
    val profilePhotoUrl: String?
)
