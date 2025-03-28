package com.compose_training25.login.data

data class LoginResponse(
    val message: String,
    val data: UserDetail,
)

data class UserDetail(
    val id: String,
    val name: String,
    val email: String,
    val token: String,
)