package ru.myapp.composeeducation.function.effecthandlers.launchedeffetc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import ru.myapp.composeeducation.ui.theme.ComposeEducationTheme

@Composable
fun EffectHandlers() {
    var i = 0
    var text by remember {
        mutableStateOf("")
    }
    ComposeEducationTheme {
//        Button(onClick = { text += "#"}) {
//            i++ // todo будет увеличиваться при каждой рекомпозиции (изменении text)
//            Text(text = text)
//        }
        LaunchedEffect(key1 = text) {
            // todo key - можно передавать состояние,
            //  при изменении состояния CoroutineScope будет отменен и запущен заново
            delay(1000L)
            println("The text is $text")
        }
    }
}

