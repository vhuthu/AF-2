package com.example.af2.farm.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.af2.R
import com.example.af2.ui.theme.GreyLight

@Preview(showSystemUi = true)
@Composable
fun DashBoardPreview() {
    DashBoardPreview()
}

@Composable
fun DashBoard() {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

        Column(modifier = Modifier
            .fillMaxWidth()
            ) {
            Text(text = "WELCOME, VHUTHU", fontSize = 18.sp , fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(start = 50.dp, top = 50.dp))

            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp).padding(start = 7.dp, end = 7.dp)
                .background(color = GreyLight, shape = RoundedCornerShape(20.dp))) {

                PieChart(
                       data = mapOf(
                            Pair("Profit",60),
                            Pair("Money In", 100),
                            Pair("Money Out", 20),
                        )
                    )
            }
            Spacer(modifier = Modifier.height(13.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(170.dp), horizontalArrangement = Arrangement.Center
                ) {

                Card(modifier = Modifier
                    .size(190.dp, 130.dp)
                    , colors = CardDefaults.cardColors(containerColor = GreyLight)) {
                    Column() {
                        Image(painter = painterResource(id = R.drawable.icons8), contentDescription = null ,  modifier = Modifier
                            .size(110.dp, 80.dp)
                            .padding(start = 56.dp, top = 10.dp) )
                        Text(text = "Book Keeping", modifier = Modifier.padding(start = 44.dp, top = 5.dp))
                    }
                }
                //-----
                Spacer(modifier = Modifier.width(20.dp))

                Card(modifier = Modifier
                    .size(190.dp, 130.dp)
                    ,colors = CardDefaults.cardColors(containerColor = GreyLight)
                    ) {
                    Column() {
                        Image(painter = painterResource(id = R.drawable.icons8), contentDescription = null ,  modifier = Modifier
                            .size(110.dp, 80.dp)
                            .padding(start = 56.dp, top = 10.dp) )
                        Text(text = "Profile Details", modifier = Modifier.padding(start = 47.dp, top = 5.dp))
                    }

                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Column(modifier = Modifier
                .fillMaxWidth().padding(6.dp)
                .background(GreyLight, shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),horizontalAlignment = Alignment.CenterHorizontally ) {
                Text(text = "QUICK TIPS", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(4.dp))


                    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp), verticalAlignment = Alignment.CenterVertically

                        ) {
                            Image(
                                modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .size(size = 29.dp),
                                painter = painterResource(id = R.drawable.iconidea),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(width = 8.dp)) // gap between image and text
                            Text(
                                text = "Maize Meal do well in overly moisture area , and require less compost !",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium, textAlign = TextAlign.Center
                            )
                        }

                    }
                    //-----

                    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp), verticalAlignment = Alignment.CenterVertically

                        ) {
                            Image(
                                modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .size(size = 29.dp),
                                painter = painterResource(id = R.drawable.iconidea),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(width = 8.dp)) // gap between image and text
                            Text(
                                text = "Making Arid lines in the field helps trap water",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium, textAlign = TextAlign.Center
                            )
                        }

                    }
                    //-----
                    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp), verticalAlignment = Alignment.CenterVertically

                        ) {
                            Image(
                                modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .size(size = 29.dp),
                                painter = painterResource(id = R.drawable.iconidea),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(width = 8.dp)) // gap between image and text
                            Text(
                                text = "Citrus fruits , eg Oranges required cold condition to produce high yield !",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium, textAlign = TextAlign.Center
                            )
                        }

                    }



            }

        }
    }
}