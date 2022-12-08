package ru.myapp.composeeducation.function

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lists() {
    LazyColumn{
        itemsIndexed(
            listOf("This", "is", "Jetpack", "Compose")
        ) { index, item ->
            Text(
                text = item,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(24.dp)
            )
        }

//        items(5000) {
//            Text(
//                text = "Item $it",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//                    .padding(24.dp)
//            )
//        }
    }

//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier
//            .verticalScroll(scrollState)
//            .fillMaxSize()
//    ) {
//        for (i in 0..50) {
//            Text(
//                text = "Item $i",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//                    .padding(24.dp)
//            )
//        }
//    }
}
