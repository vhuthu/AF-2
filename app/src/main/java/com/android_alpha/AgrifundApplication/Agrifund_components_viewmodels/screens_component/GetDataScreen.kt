package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.screens_component



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.af2.Agrifund_components_viewmodels.utilities.viewmodel.SharedViewModel
//import com.example.cruddroid.util.SharedViewModel
import com.example.cruddroid.util.UserData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDataScreen(
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

    Column(modifier = Modifier.fillMaxSize(),) {

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
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    value = itemID ,
                    onValueChange = {itemID = it },
                    label = { Text(text = "Item ID") })

                //get data button
                Button(modifier = Modifier
                    .padding(start = 10.dp)
                    .width(100.dp),
                    onClick = {
                        sharedViewModel.retrieveData(
                            itemID = itemID,
                            context = context
                        ){ data ->
                            nameOfProduct = data.nameOfProduct
                            dateOfTransaction = data.dateOfTransaction
                            typeOfTransaction = data.typeOfTransaction
                            price = data.price.toString()
                            priceInt = price.toInt()
                        }
                    }
                ) {
                    Text(text = "Get Data")
                }
            }

//            TextField(value = name, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White), onValueChange = { name = it }, placeholder = { Text(
//                text = "Vhuthu"
//            ) },label = { Text(text = "Name", fontWeight = FontWeight.Bold)})

            // Name Of Product
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                value = nameOfProduct ,
                onValueChange = {nameOfProduct = it },
                label = { Text(text = "Name Of Product") })

            // Type Of Transaction
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                value = typeOfTransaction ,
                onValueChange = {typeOfTransaction = it },
                label = { Text(text = "Type Of Transaction") })

            // Date of Transaction
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                value = dateOfTransaction ,
                readOnly = true,
                onValueChange = {dateOfTransaction = it },
                label = { Text(text = "Date of Transaction") })

            //id number
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                value = price ,
                onValueChange = {
                    price = it
                    if (price.isNotEmpty()){
                        priceInt = price.toInt()
                    }

                },
                label = { Text(text = "Amount") },
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
                        dateOfTransaction = dateOfTransaction,
                        typeOfTransaction = typeOfTransaction,
                        price = priceInt

                        )
                    sharedViewModel.saveData(userData = userData, context = context)
                })
            {
                Text(text = "Save Records of Transaction")
            }

            //delete button here !!
            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                ,onClick = {

                    sharedViewModel.deleteData(itemID = itemID, context = context, navController = navController)
                })
            {
                Text(text = "Delete Record")
            }

        }
    }
}
