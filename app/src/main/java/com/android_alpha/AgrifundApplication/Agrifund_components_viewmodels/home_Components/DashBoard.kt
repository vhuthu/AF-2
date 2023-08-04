package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.home_Components

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.af2.Agrifund_components_viewmodels.single_components.Profile
import com.example.af2.R
import com.example.af2.Agrifund_components_viewmodels.single_components.Records
import com.example.af2.ui.theme.Greenlines
import com.example.af2.ui.theme.GreyLight

@Preview(showSystemUi = true)
@Composable
fun DashBoardPreview() {
    DashBoardPreview()
}

@Composable
fun DashBoard() {

    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 14.dp, end = 14.dp), color = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Welcome, VHUTHU",
                fontSize = 23.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 10.dp, top = 30.dp)
            )

            Text(
                text = "Financial overview ",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                    .height(225.dp)
                    .background(color = GreyLight, shape = RoundedCornerShape(20.dp))
            ) {

                PieChart(
                    data = mapOf(
                        Pair("Profit", 30),
                        Pair("Money In", 150),
                        Pair("Money Out", 20),
                    )
                )
            }
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Navigate pages ",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            )
            Spacer(modifier = Modifier.height(9.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp), horizontalArrangement = Arrangement.Center
            ) {

                Card(
                    modifier = Modifier
                        .size(190.dp, 106.dp).clickable { context.startActivity(Intent(context,
                            Records::class.java))  },
                    colors = CardDefaults.cardColors(containerColor = GreyLight)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.icons8),
                            contentDescription = null,
                            modifier = Modifier
                                .size(110.dp, 80.dp)
                                .padding(start = 56.dp, top = 2.dp)
                        )
                        Text(
                            text = "Book Keeping",
                            modifier = Modifier.padding(start = 44.dp, top = 2.dp)
                        )
                    }
                }
                //-----
                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .size(190.dp, 106.dp).clickable { context.startActivity(Intent(context,
                            Profile::class.java))  },
                    colors = CardDefaults.cardColors(containerColor = GreyLight)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.icons8),
                            contentDescription = null,
                            modifier = Modifier
                                .size(110.dp, 80.dp)
                                .padding(start = 56.dp, top = 2.dp)
                        )
                        Text(
                            text = "Profile Details",
                            modifier = Modifier.padding(start = 44.dp, top = 2.dp)
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            ) {
                Text(text = "QUICK TIPS", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(3.dp))
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                    Spacer(modifier = Modifier.height(18.dp))
                    Card(
                        border = BorderStroke(1.dp, Greenlines),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .height(45.dp), verticalAlignment = Alignment.CenterVertically

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
                    Spacer(modifier = Modifier.height(18.dp))
                    Card(
                        border = BorderStroke(1.dp, Greenlines),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .height(45.dp), verticalAlignment = Alignment.CenterVertically

                        ) {
                            Image(
                                modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .height(52.dp)
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
                    Spacer(modifier = Modifier.height(18.dp))
                    Card(
                        border = BorderStroke(1.dp, Greenlines),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                                .height(45.dp), verticalAlignment = Alignment.CenterVertically

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
}