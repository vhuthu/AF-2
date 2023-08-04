package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.home_Components.Home
import com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.login_component.LoginScreen
import com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.login_component.LoginViewModel
import com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.login_component.SignUpScreen


enum class LoginRoutes {
    SignUp,
    SignIn
}

enum class HomeRoutes {
    Home,
    Detail
}


@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel
) {
    NavHost(navController = navController, startDestination = LoginRoutes.SignIn.name) {

        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(
                onNavToHomePage = {
                    navController.navigate(HomeRoutes.Home.name) {
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignIn.name) {
                            inclusive = true
                        }
                    }
                }, loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.SignUp.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }

            }
        }

        composable(route = LoginRoutes.SignUp.name) {
            SignUpScreen(
                onNavToHomePage = {
                    navController.navigate(HomeRoutes.Home.name) {
                        popUpTo(LoginRoutes.SignUp.name) {
                            inclusive = true
                        }
                    }
                }, loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.SignIn.name)

            }
        }

        composable(route = HomeRoutes.Home.name) {
            Home()
        }
    }


}