package ru.myapp.composeeducation.function.effecthandlers.disposableeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun DisposableEffectDemo() {
    val  lifecycleOwner = LocalLifecycleOwner.current
    val observer = LifecycleEventObserver { _, event -> // todo объявление при каждой рекомпозиции
        if (event == Lifecycle.Event.ON_PAUSE) {
            println("On pause called")
        }
    }
    
    DisposableEffect(key1 = lifecycleOwner) { // todo Одноразовый эфект
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("On pause called")
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer) // todo добавляет observer в lifecycleOwner

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer) // todo удаляет привязку если observer бьльше не нужен
        }
    }
}
