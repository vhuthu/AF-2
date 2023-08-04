package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.single_components

import android.content.Intent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.af2.MainActivity
import com.example.af2.R
import com.example.af2.ui.theme.ChartGreen
//import com.example.onboarding.ui.theme.ChartGreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState


@Preview(showBackground = true)
@Composable
fun PreviewFunction() {
    Surface(modifier = Modifier.fillMaxSize()) {
        MainFuction()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainFuction() {
/*remember that onBoarding Function we created earlier ??   ,
*this bad boy helps us to load the info we need to that function
* 18/ 06/ 2023 */
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.raw.corn,
            "Let us help you grow your respective businesses",
            " Grow with AgriFund, Get Funding tailored For Your business"
        )
    )

    items.add(
        OnBoardingData(
            R.raw.regis,
            "Fill out one simple application and track your outcome ",
            "Complete the application and remember to upload the required documents."
        )
    )


    items.add(
        OnBoardingData(
            R.raw.book,
            "Bookkeeping Made Simpler",
            " Numbers that tell your success story, Let us help you with timely reports while you focus on your farm"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items ,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)


    )

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(item: ArrayList<OnBoardingData>, pagerState: PagerState, modifier: Modifier) {

    Box(modifier = modifier) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(modifier = Modifier
                    .padding(60.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {

                    LoaderIntro(modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally),item[page].image)

                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(10.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = item[page].desc,
                        modifier = Modifier.padding(top = 30.dp, start = 20.dp , end = 20.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center

                    )

                }
            }

            PagerIndicator(item.size , pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSection(pagerState.currentPage)
        }
    }
}

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row( horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier.padding(top = 60.dp)) {
        repeat(size){
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected:Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(modifier = Modifier
        .padding(1.dp)
        .height(10.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(if (isSelected) ChartGreen else Color.Gray.copy(alpha = 0.5f))) {

    }
}

@Composable
fun BottomSection(currentPager: Int) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPager == 2){
            OutlinedButton(onClick = { context.startActivity(Intent(context, MainActivity::class.java))} , shape = RoundedCornerShape(50), colors = ButtonDefaults.buttonColors(containerColor = ChartGreen)) {
                Text(
                    text = "GET STARTED",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.White
                )
            }
        }else{
            SkipNextButton(text = "Skip", modifier = Modifier.padding(start = 17.dp))
            SkipNextButton(text = "", modifier = Modifier.padding(start = 17.dp))
        }

    }
}

@Composable
fun SkipNextButton(text: String ,modifier: Modifier) {

    Text(
        text = text,
        color = Color.Black,
        modifier = modifier,
        fontSize = 18.sp,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Medium
    )
}

