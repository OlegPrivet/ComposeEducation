package ru.myapp.composeeducation.function.effecthandlers.rememberupdatedstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedState(
    onTimeout: () -> Unit
) {
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout) // todo новое значение при рекомпозиции
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout()
    }
}
