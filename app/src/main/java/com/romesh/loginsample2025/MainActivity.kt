package com.romesh.loginsample2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.romesh.loginsample2025.apphost.AppNavHost
import com.romesh.loginsample2025.ui.theme.LoginSample2025Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginSample2025Theme {
                AppNavHost()
            }
        }
    }
}
