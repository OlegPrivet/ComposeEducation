package ru.myapp.composeeducation.function

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Modifiers() {
    Column(modifier = Modifier
        .background(Color.Magenta)
        .fillMaxHeight(fraction = 0.5f)
        .fillMaxWidth()
        .border(5.dp, Color.Green, RoundedCornerShape(10))
        .padding(10.dp)
        .border(5.dp, Color.Blue, RoundedCornerShape(10))
        .padding(10.dp)
        .border(5.dp, Color.Gray, RoundedCornerShape(10))
        .padding(10.dp)
        .border(5.dp, Color.Red, RoundedCornerShape(10))
        .padding(10.dp)
    ) {
        Text(text = "Hello")
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "World")
    }
}
