package ru.myapp.composeeducation.function

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ShowProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ProgressBarDemo(
            percentage = 0.8f,
            number = 200,
            fontSize = 28.sp,
            radius = 50.dp,
            color = Color.Green,
            strokeWidth = 8.dp,
            animationDuration = 1000,
            animationDelay = 0
        )
    }
}

@Composable
fun ProgressBarDemo(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    val currentPercentage = remember { Animatable(0f) }

    LaunchedEffect(percentage) {
        currentPercentage.animateTo(
            percentage,
            animationSpec = tween(
                durationMillis = animationDuration,
                delayMillis = animationDelay
            )
        )
    }
    Box(
        modifier = Modifier.size(radius * 2),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(radius * 2)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}
