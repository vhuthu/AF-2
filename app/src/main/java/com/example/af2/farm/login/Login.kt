package com.example.af2.farm.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.af2.ui.theme.AF2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToSignUpPage: () -> Unit
) {


    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Login", style = MaterialTheme.typography.titleLarge
        )

        if (isError) {
            Text(text = loginUiState?.loginError ?: "Unknown Error", color = Color.Red)
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.userName ?: "",
            onValueChange = { loginViewModel?.onUserNameChange(it) },
            label = { Text(text = "EMAIL") },
            isError = isError
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.password ?: "",
            onValueChange = { loginViewModel?.onPasswordChange(it) },
            label = { Text(text = "PASSWORD") },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

//button to submit
        Button(onClick = { loginViewModel?.loginUser(context) }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

            Text(text = "Don't Have an Account Yet ?")
            Spacer(modifier = Modifier.width(5.dp))
            TextButton(onClick = { onNavToSignUpPage.invoke() }) {
                Text(text = "SignUp")
            }
        }


        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        // if the user has logged in successfully , go to dashboard screen
        LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if (loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToLogInPage: () -> Unit
) {


    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Sign Up", style = MaterialTheme.typography.titleLarge
        )

        if (isError) {
            Text(text = loginUiState?.signUpError ?: "Unknown Error", color = Color.Red)
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.userNameSignUp ?: "",
            onValueChange = { loginViewModel?.onUserNameChangeSignUp(it) },
            label = { Text(text = "EMAIL") },
            isError = isError
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.passwordSignUp ?: "",
            onValueChange = { loginViewModel?.onPasswordChangeSignUp(it) },
            label = { Text(text = "PASSWORD") },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.confirmPasswordSignUp ?: "",
            onValueChange = { loginViewModel?.onConfirmPasswordChange(it) },
            label = { Text(text = "CONFIRM PASSWORD") },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )


//button to submit
        Button(onClick = { loginViewModel?.createUser(context) }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

            Text(text = "Already Have an Account Yet ?")
            Spacer(modifier = Modifier.width(5.dp))
            TextButton(onClick = { onNavToLogInPage.invoke() }) {
                Text(text = "Sign In")
            }
        }


        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        // if the user has logged in successfully , go to dashboard screen
        LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if (loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {

    AF2Theme() {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen() {

    AF2Theme() {
        SignUpScreen(onNavToHomePage = { /*TODO*/ }) {

        }
    }
}