package ru.myapp.composeeducation.function.effecthandlers.producestate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

@Composable
fun ProduceStateDemo(
    countUpTo: Int
): State<Int> {
    return produceState(initialValue = 0) { // todo аналог flow
        while (value < countUpTo) {
            delay(1000L)
            value++
        }
    }
}
