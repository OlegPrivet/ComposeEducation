package ru.myapp.composeeducation.function.effecthandlers.launchedeffetc

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@Composable
fun LaunchedEffectAnimation(
    counter: Int
) {
    val animatable = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = counter) { // todo используется состояние счетчика
        animatable.animateTo(counter.toFloat()) // todo перезапускается при каждом изменении counter
        // todo вариант использования - для отображения прогресс,
        //  в зависимости от каких-либо параметров
    }
}
