package ru.myapp.composeeducation.function.effecthandlers.sideeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun SideEffectDemo(
    nonComposeCounter: Int
) {
    SideEffect { // todo всегда, когда произошла успешная рекомпозиция
        // todo используется в случаях, когда переменная не является состоянием,
        //  но ноужно обработать как состояние
        println("Called after every successful recomposition ")
    }
}
