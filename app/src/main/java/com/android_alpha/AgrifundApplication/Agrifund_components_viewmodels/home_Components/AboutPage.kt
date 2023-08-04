package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.home_Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.af2.R


@Composable
fun Header() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        val buttonSpacing = 40.dp
        /*
        Row(
            modifier = Modifier.padding(top = 45.dp),
        ) {
            BackButton(activity = activity)
        }*/

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("GET FUNDING TAILORED FOR YOUR BUSINESS\n")
                    append("\n")

                }
            }
            Text(
                text = annotatedText,
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(top = 35.dp)
            )



            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                )
            {

                //Add your ImageView here, aligned horizontally with the Text

                Image(painter = painterResource(id = R.drawable.img_2), modifier = Modifier.size(200.dp,200.dp), contentDescription = null)
//                Image(
//                    painter = painterResource(R.drawable), // Replace with your image resource
//                    contentDescription = null, // Provide a content description if required
//                    modifier = Modifier
//                        .padding(top = 5.dp)
//                        .size(205.dp)
//
//                )
            } //funding new

            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Secure your business's future with a strategic planning.\n",
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Text(
                text = "With tailored plans and financing options designed to support your aspirations. Act now and witness your vision materialize into success. Your tomorrow starts with our support today.\n",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(buttonSpacing))
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .width(300.dp)
                        .height(50.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF9DAE62),
                        contentColor = Color.White
                    )


                )


                {
                    Text("Proceed")
                }

                Spacer(modifier = Modifier.height(buttonSpacing))


            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Header()
}