package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.screens_component



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.af2.Agrifund_components_viewmodels.navigation.Screens
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.af2.ui.theme.ChartGreen
import com.example.af2.ui.theme.Profit


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    Column(modifier = Modifier

        .fillMaxSize()
        .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {

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

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 250.dp)) {
               Icon(imageVector = Icons.Outlined.ExitToApp, contentDescription = null)
            }
        }

       Text(text = "Bookkeeping Services", modifier = Modifier, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
Spacer(modifier = Modifier.height(30.dp))


            Box(modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
                .border(1.dp, Color.Black.copy(alpha = 0.2f))) {

                Row(modifier = Modifier.padding(start = 20.dp, top = 35.dp)) {
                    Column() {
                        Text(text = "Money In", fontSize = 16.sp, color = ChartGreen, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(text = "Money Out",fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(text = "Total Profit",fontSize = 16.sp, color = Profit, fontWeight = FontWeight.Bold)


                    }
                    Spacer(modifier = Modifier.width(100.dp))
                    Column() {
                        Text(text = "R1000", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(text = "R350",fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(text = "R650",fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier

            .fillMaxWidth()
            .height(300.dp)
            .border(1.dp, Color.Black.copy(alpha = 0.2f))) {

            var field : String by remember { mutableStateOf("") }

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp),
                    value = field,
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
                    onValueChange = { field = it },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(
                            onClick = { navController.navigate(route = Screens.GetDataScreen.route) }

                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "back_button"
                            )
                        }
                    },
                    label = {
                        Text(
                            text = "Maize Seeds \n17/07/2023",
                            fontWeight = FontWeight.Bold
                        )
                    })


                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp),
                    value = field,
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
                    onValueChange = { field = it },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(
                            onClick = { navController.navigate(route = Screens.GetDataScreen.route) }

                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "back_button"
                            )
                        }
                    },
                    label = {
                        Text(
                            text = "Sweet Potatoes \n14/07/2023",
                            fontWeight = FontWeight.Bold
                        )
                    })



                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp),
                    value = field,
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
                    onValueChange = { field = it },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(
                            onClick = { navController.navigate(route = Screens.GetDataScreen.route) }

                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "back_button"
                            )
                        }
                    },
                    label = {
                        Text(
                            text = "Ground Nuts \n11/07/2023",
                            fontWeight = FontWeight.Bold
                        )
                    })

                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp),
                    value = field,
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
                    onValueChange = { field = it },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(
                            onClick = { navController.navigate(route = Screens.GetDataScreen.route) }

                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "back_button"
                            )
                        }
                    },
                    label = {
                        Text(
                            text = "Pine Nuts \n13/07/2023",
                            fontWeight = FontWeight.Bold
                        )
                    })




            }


        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = Modifier.width(200.dp), colors = ButtonDefaults.buttonColors(containerColor = ChartGreen),
           onClick = {navController.navigate(route = Screens.AddDataScreen.route)  }) {
           Text(text = "Add Record")
        }

        //here am going to add data

        OutlinedButton(modifier = Modifier.width(200.dp), border = BorderStroke(1.dp, ChartGreen), colors = ButtonDefaults.outlinedButtonColors(contentColor = ChartGreen),
            onClick = { navController.navigate(route = Screens.GetDataScreen.route)}) {
            Text(text = "View Record")

        }

//        OutlinedButton(modifier = Modifier.fillMaxWidth(),
//            onClick = { navController.navigate(route = Screens.DeleteDataScreen.route)}) {
//            Text(text = "Delete Data")
//
//        }
//
//        OutlinedButton(modifier = Modifier.fillMaxWidth(),
//            onClick = { navController.navigate(route = Screens.UpdateDataScreen.route)}) {
//            Text(text = "Update Data")
//
//        }

   }
}

@Preview(showSystemUi = true)
@Composable
fun PreMain() {
    MainScreen(navController = rememberNavController())
}


