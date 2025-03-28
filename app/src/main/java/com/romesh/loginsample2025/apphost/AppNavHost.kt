package com.romesh.loginsample2025.apphost

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.romesh.loginsample2025.screens.LoginScreen
import com.romesh.loginsample2025.screens.SignupScreen
import com.romesh.loginsample2025.vm.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(viewModel = authViewModel, navController = navController)
        }
        composable("signup") {
            SignupScreen(viewModel = authViewModel, navController = navController)
        }
    }
}