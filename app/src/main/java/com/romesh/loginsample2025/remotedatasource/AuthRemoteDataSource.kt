package com.romesh.loginsample2025.remotedatasource
import com.compose_training25.login.data.LoginRequest
import com.compose_training25.login.data.LoginResponse
import com.compose_training25.login.data.SignupRequest
import com.compose_training25.login.data.SignupResponse
import com.romesh.loginsample2025.network.ApiService
import com.romesh.loginsample2025.network.ResultCallBack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor (private val apiService: ApiService) {
    suspend fun login(loginRequest: LoginRequest): Flow<ResultCallBack<LoginResponse>> = flow {
        try {
            emit(ResultCallBack.Loading)
            val response = apiService.login(loginRequest)
            if (response.isSuccessful) {
                emit(ResultCallBack.Success(response.body()!!))
            } else {
                emit(ResultCallBack.Error("Login failed"))
            }
        } catch (e: Exception) {
            emit(ResultCallBack.Error(e.message ?: "Unknown error"))
        }
    }

    suspend fun signup(signupRequest: SignupRequest): Flow<ResultCallBack<SignupResponse>> = flow {
        try {
            emit(ResultCallBack.Loading)
            val response = apiService.signup(signupRequest)
            if (response.isSuccessful) {
                emit(ResultCallBack.Success(response.body()!!))
            } else {
                emit(ResultCallBack.Error("Signup failed"))
            }
        } catch (e: Exception) {
            emit(ResultCallBack.Error(e.message ?: "Unknown error"))
        }
    }
}
