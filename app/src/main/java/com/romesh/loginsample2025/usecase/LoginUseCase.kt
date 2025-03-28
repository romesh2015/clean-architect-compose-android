package com.romesh.loginsample2025.usecase

import com.compose_training25.login.data.LoginRequest
import com.compose_training25.login.data.LoginResponse
import com.romesh.loginsample2025.authrepo.AuthRepository
import com.romesh.loginsample2025.network.ResultCallBack
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun execute(loginRequest: LoginRequest): Flow<ResultCallBack<LoginResponse>> {
        return authRepository.login(loginRequest)
    }
}