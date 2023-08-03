package com.example.af2

import NavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.af2.farm.login.LoginViewModel
import com.example.af2.farm.navigation.Navigation
import com.example.af2.farm.util.SharedViewModel
import com.example.af2.ui.theme.AF2Theme

class MainActivity : ComponentActivity() {
//    private lateinit var navController: NavHostController
//    private val sharedViewModel: SharedViewModel by viewModels()
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

//                    navController = rememberNavController()
//                    NavGraph(navController = navController,
//                        sharedViewModel = sharedViewModel)
                }
            }
        }
    }
}
