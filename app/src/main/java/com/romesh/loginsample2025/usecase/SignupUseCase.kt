package com.romesh.loginsample2025.usecase

import com.compose_training25.login.data.SignupRequest
import com.compose_training25.login.data.SignupResponse
import com.romesh.loginsample2025.authrepo.AuthRepository
import com.romesh.loginsample2025.network.ResultCallBack
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignupUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun execute(signupRequest: SignupRequest): Flow<ResultCallBack<SignupResponse>> {
        return authRepository.signup(signupRequest)
    }
}