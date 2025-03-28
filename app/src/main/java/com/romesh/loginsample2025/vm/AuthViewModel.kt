package com.romesh.loginsample2025.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose_training25.login.data.LoginRequest
import com.compose_training25.login.data.LoginResponse
import com.compose_training25.login.data.SignupRequest
import com.compose_training25.login.data.SignupResponse
import com.romesh.loginsample2025.network.ResultCallBack
import com.romesh.loginsample2025.usecase.LoginUseCase
import com.romesh.loginsample2025.usecase.SignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val signupUseCase: SignupUseCase
) : ViewModel() {

    private val _loginState = MutableLiveData<ResultCallBack<LoginResponse>>()
    val loginState: LiveData<ResultCallBack<LoginResponse>> = _loginState

    private val _signupState = MutableLiveData<ResultCallBack<SignupResponse>>()
    val signupState: LiveData<ResultCallBack<SignupResponse>> = _signupState

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            loginUseCase.execute(loginRequest).collect { result ->
                _loginState.value = result
            }
        }
    }

    fun signup(signupRequest: SignupRequest) {
        viewModelScope.launch {
            signupUseCase.execute(signupRequest).collect { result ->
                _signupState.value = result
            }
        }
    }
}
