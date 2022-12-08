package ru.myapp.composeeducation.function

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintLayoutScreen() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val guidLine = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            top.linkTo(guidLine)
            start.linkTo(parent.start)
            width = Dimension.percent(0.2f)
            height = Dimension.percent(0.2f)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.percent(0.3f)
            height = Dimension.percent(0.3f)
        }
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = constraints
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redBox")
        )
    }
}
