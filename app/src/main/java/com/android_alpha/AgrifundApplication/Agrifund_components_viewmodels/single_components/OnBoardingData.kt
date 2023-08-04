package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.single_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

data class OnBoardingData(val image : Int , val title : String , val desc : String  )

/*
* this function lets me manipulate json file into animation for the onboarding screen
*
*
* */
@Composable
fun LoaderIntro(modifier: Modifier , image: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))
    val progress by animateLottieCompositionAsState(composition)
    
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}