package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.login_component

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.af2.ui.theme.ChartGreen


@Preview(showSystemUi = true)
@Composable
fun PreProfile() {
    Profile(navController = rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController

) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

        Column() {
            Row(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { navController.popBackStack() }

                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")

                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Text(text = "HELLO, Vhuthu ", fontWeight = FontWeight.ExtraBold, fontSize = 30.sp)
            Text(text = "Profile Details", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(50.dp))
            var name : String by remember { mutableStateOf("") }
            var surname : String by remember { mutableStateOf("") }
            var email : String by remember { mutableStateOf("") }
            var phonenumber : String by remember { mutableStateOf("") }
            var idnumber : String by remember { mutableStateOf("") }

            TextField(value = name, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White), onValueChange = { name = it }, placeholder = { Text(
                text = "Vhuthu"
            ) },label = { Text(text = "Name", fontWeight = FontWeight.Bold)})
            TextField(value = surname, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White), onValueChange = { name = it }, placeholder = { Text(
                text = "Kwinda"
            )}, label = { Text(text = "Surname", fontWeight = FontWeight.Bold)})
            TextField(value = email, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White), onValueChange = { name = it }, placeholder = { Text(
                text = "vhuthu@gmail.com"
            )}, label = { Text(text = "Email", fontWeight = FontWeight.Bold)})
            TextField(value = phonenumber, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White), onValueChange = { name = it }, placeholder = { Text(
                text = "076 939 9085"
            )} ,label = { Text(text = "Phone Number", fontWeight = FontWeight.Bold)})
            TextField(value = idnumber, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White), onValueChange = { name = it }, placeholder = { Text(
                text = "8901256123080"
            )}, label = { Text(text = "Id Number", fontWeight = FontWeight.Bold)})

            Spacer(modifier = Modifier.height(40.dp))
            val context = LocalContext.current
            Button(onClick = { Toast.makeText(context,"Updated Successfully", Toast.LENGTH_SHORT).show()},  modifier = Modifier.size(200.dp,49.dp),colors = ButtonDefaults.buttonColors(containerColor = ChartGreen)) {
                Text(text = "Submit")
            }
        }


    }
}