package com.romesh.loginsample2025.authrepo

import com.compose_training25.login.data.LoginRequest
import com.compose_training25.login.data.LoginResponse
import com.compose_training25.login.data.SignupRequest
import com.compose_training25.login.data.SignupResponse
import com.romesh.loginsample2025.network.ResultCallBack
import com.romesh.loginsample2025.remotedatasource.AuthRemoteDataSource
import kotlinx.coroutines.flow.Flow

class AuthRepository(private val authRemoteDataSource: AuthRemoteDataSource) {

    suspend fun login(loginRequest: LoginRequest): Flow<ResultCallBack<LoginResponse>> {
        return authRemoteDataSource.login(loginRequest)
    }

    suspend fun signup(signupRequest: SignupRequest): Flow<ResultCallBack<SignupResponse>> {
        return authRemoteDataSource.signup(signupRequest)
    }
}