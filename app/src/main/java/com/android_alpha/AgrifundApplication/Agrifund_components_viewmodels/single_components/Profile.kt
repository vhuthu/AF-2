package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.single_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.af2.Agrifund_components_viewmodels.utilities.viewmodel.SharedViewModel
import com.example.af2.ui.theme.AF2Theme

class Profile : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AF2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    com.example.af2.Agrifund_components_viewmodels.login_component.Profile(navController = rememberNavController())
                }
            }
        }
    }
}

