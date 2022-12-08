package ru.myapp.composeeducation.function

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import ru.myapp.composeeducation.R

@Composable
fun StylingText() {
    val fontFamily = FontFamily(
        Font(R.font.island_moments_regular, FontWeight.Normal)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green
                    )
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green
                    )
                ) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 70.sp,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center
        )
    }
}
