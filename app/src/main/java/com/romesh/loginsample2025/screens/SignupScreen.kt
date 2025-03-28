package com.romesh.loginsample2025.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.romesh.loginsample2025.vm.AuthViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.compose_training25.login.data.SignupRequest
import com.romesh.loginsample2025.network.ResultCallBack

@Composable
fun SignupScreen(viewModel: AuthViewModel, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val signupState by viewModel.signupState.observeAsState(ResultCallBack.Loading)

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val signupRequest = SignupRequest(email, password)
                viewModel.signup(signupRequest)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (signupState is ResultCallBack.Loading) {
            CircularProgressIndicator()
        }
        if (signupState is ResultCallBack.Success) {
            Text("Signup Successful")
        }
        if (signupState is ResultCallBack.Error) {
            Text((signupState as ResultCallBack.Error).message, color = Color.Red)
        }
        TextButton(onClick = {
            navController.popBackStack()
        }) {
            Text("Already have an account? Log In")
        }
    }
}