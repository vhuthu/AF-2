package com.android_alpha.AgrifundApplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.af2.Agrifund_components_viewmodels.login_component.LoginViewModel
import com.example.af2.Agrifund_components_viewmodels.navigation.Navigation
import com.example.af2.ui.theme.AF2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            AF2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Navigation(loginViewModel = loginViewModel)
                }
            }
        }
    }
}
