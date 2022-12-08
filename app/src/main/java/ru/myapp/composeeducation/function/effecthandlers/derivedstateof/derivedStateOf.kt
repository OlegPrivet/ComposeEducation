package ru.myapp.composeeducation.function.effecthandlers.derivedstateof

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
    // val counterText = "The counter is $counter"  todo пересоздается из-за обновления counter
    val counterText by derivedStateOf { // для вычислений при использовании нескольких состояний
        "The counter is $counter" // todo производное состояние. Строка будет кэшироваться и не будет пересчитываться кокатенация
    }
    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}
