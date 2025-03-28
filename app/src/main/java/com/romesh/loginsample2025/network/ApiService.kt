package com.romesh.loginsample2025.network

import com.compose_training25.login.data.LoginRequest
import com.compose_training25.login.data.LoginResponse
import com.compose_training25.login.data.SignupRequest
import com.compose_training25.login.data.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("signup")
    suspend fun signup(@Body signupRequest: SignupRequest): Response<SignupResponse>
}