package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.screens_component



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.af2.Agrifund_components_viewmodels.utilities.viewmodel.SharedViewModel
//import com.example.cruddroid.util.SharedViewModel
import com.example.cruddroid.util.UserData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    var itemID : String by remember { mutableStateOf("") }
    var nameOfProduct : String by remember { mutableStateOf("") }
    var typeOfTransaction : String by remember { mutableStateOf("") }
    var dateOfTransaction : String by remember { mutableStateOf("") }
    var price : String by remember { mutableStateOf("") }
    var priceInt : Int by remember { mutableStateOf(0) }

//here is the context that is gonna let me route between composables lets go!!!!

    val context = LocalContext.current

    //now lets make the layout to feed the information lets go!!!!

    Column(modifier = Modifier.fillMaxSize()) {

        //back button lies here
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
        //add data layout here

        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //item Id
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = itemID ,
                onValueChange = {itemID = it },
                label = { Text(text = "Transaction ID")})

            // name of product
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nameOfProduct ,
                onValueChange = {nameOfProduct = it },
                label = { Text(text = "Name of Product")})

            // cellnumber
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = typeOfTransaction ,
                onValueChange = {typeOfTransaction = it },
                label = { Text(text = "Type of Transaction")})

            // date of transaction
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = dateOfTransaction ,
                onValueChange = {dateOfTransaction = it },
                label = { Text(text = "Date of Transaction")})

            //amount
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = price ,
                onValueChange = {
                    price = it
                    if (price.isNotEmpty()){
                        priceInt = price.toInt()
                    }
                },
                label = { Text(text = "Amount")},
                keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Number)
            )

            //save button here !!
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                ,onClick = {
                    val userData = UserData(
                        itemID = itemID,
                        nameOfProduct = nameOfProduct,
                        typeOfTransaction = typeOfTransaction,
                        dateOfTransaction = dateOfTransaction,
                        price = priceInt
                    )
                    sharedViewModel.saveData(userData = userData, context = context)
                })
            {
                Text(text = "Save Records")
            }

        }
    }
}


