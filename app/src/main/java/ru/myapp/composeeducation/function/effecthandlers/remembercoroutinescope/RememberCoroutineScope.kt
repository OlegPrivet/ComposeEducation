package ru.myapp.composeeducation.function.effecthandlers.remembercoroutinescope

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScope() {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            scope.launch { // todo запуск корутин только в блоках, где минимальны рекомпозиции
                delay(1000L)
                println("Hello World!!!")
            }
        }
    ) {

    }
}
