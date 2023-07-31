package com.example.af2.farm.home

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.af2.ui.theme.ChartGreen
import com.example.af2.ui.theme.ChartLightGreen
import com.example.af2.ui.theme.ChartRed

import java.time.Duration


@Composable
fun PieChart(
    data : Map<String , Int>,
    radiusOuter : Dp = 60.dp,
    chartBarWidth: Dp = 25.dp,
    animDuration: Int = 3000
) {
        val totalSum = data.values.sum()
        val floatValue = mutableListOf<Float>()

    data.values.forEachIndexed{ index, values ->
    floatValue.add(index, 360 * values.toFloat() / totalSum.toFloat())
    }

    val colors = listOf(
        ChartGreen,
        ChartLightGreen,
        ChartRed
    )

    var animationPlayed by remember { mutableStateOf(false) }

    var lastValue = 0f

    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )
    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true){
        animationPlayed = true
    }

    Row(modifier = Modifier.fillMaxWidth().padding(start = 30.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center

    ) {

        Box(modifier = Modifier.size(animateSize.dp),
        contentAlignment = Alignment.Center
            ) {

            Canvas(modifier = Modifier
                .size(radiusOuter * 2f)
                .rotate(animateRotation)){

                floatValue.forEachIndexed { index, value ->
                    drawArc(
                        color = colors[index],
                        lastValue,
                        value,
                        useCenter = false,
                        style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Butt)

                    )
                    lastValue += value
                }
            }
        }

        DetailsChart(data = data, colors = colors)
        
    }
}

@Composable
fun DetailsChart(
    data : Map<String , Int >,
    colors  : List<Color>
) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
    ) {
        data.values.forEachIndexed { index, value ->
            
            DetailsPieChartItems(
                data = Pair(data.keys.elementAt(index), value),
                color = colors[index]
            )
        }
    }
}

@Composable
fun DetailsPieChartItems(
    data : Pair<String ,Int >,
    height : Dp = 19.dp ,
    color : Color
) {
                    
    Surface(modifier = Modifier.padding(vertical = 6.dp , horizontal =  20.dp), color = Color.Transparent) {
        
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            Box(modifier = Modifier
                .background(
                    color = color
                )
                .size(height)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = data.first,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = data.second.toString(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.Gray
                )
            }
        }
    }
}