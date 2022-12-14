package ru.myapp.composeeducation.function.meditationui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.myapp.composeeducation.R
import ru.myapp.composeeducation.ui.theme.Beige1
import ru.myapp.composeeducation.ui.theme.Beige2
import ru.myapp.composeeducation.ui.theme.Beige3
import ru.myapp.composeeducation.ui.theme.BlueViolet1
import ru.myapp.composeeducation.ui.theme.BlueViolet2
import ru.myapp.composeeducation.ui.theme.BlueViolet3
import ru.myapp.composeeducation.ui.theme.ButtonBlue
import ru.myapp.composeeducation.ui.theme.DarkerButtonBlue
import ru.myapp.composeeducation.ui.theme.DeepBlue
import ru.myapp.composeeducation.ui.theme.LightGreen1
import ru.myapp.composeeducation.ui.theme.LightGreen2
import ru.myapp.composeeducation.ui.theme.LightGreen3
import ru.myapp.composeeducation.ui.theme.LightRed
import ru.myapp.composeeducation.ui.theme.OrangeYellow1
import ru.myapp.composeeducation.ui.theme.OrangeYellow2
import ru.myapp.composeeducation.ui.theme.OrangeYellow3
import ru.myapp.composeeducation.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            GreetingSection()
            Spacer(modifier = Modifier.height(16.dp))
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            Spacer(modifier = Modifier.height(16.dp))
            CurrentMeditation()
            Spacer(modifier = Modifier.height(16.dp))
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphones,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphones,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphones,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Oleg"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.Search,
            contentDescription = "Search",
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        itemsIndexed(chips) { index, chip ->
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = index
                    }
                    .background(
                        if (selectedChipIndex == index) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = chip,
                    color = TextWhite
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation - 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color.White
            )
        }
    }
}

@Composable
fun FeatureSection(
    features: List<Feature>
) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Features",
            style = MaterialTheme.typography.h1
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxHeight(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 100.dp)
        ) {
            itemsIndexed(features) { index, item ->
                FeatureItem(feature = item)
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = mediumColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.icon),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}
