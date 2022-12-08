package ru.myapp.composeeducation.function.effecthandlers.launchedeffetc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@Composable
fun LaunchedEffectFlow(
    viewModel: LaunchedEffectViewModel
) {
    LaunchedEffect(key1 = true) { // todo вызывается только один раз
        viewModel.sharedFlow.collect { event -> // не выполняется при каждой рекомпозиции
            when (event) {
                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackBar -> {

                }
            }
        }
    }
}

class LaunchedEffectViewModel: ViewModel() {
    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvents.ShowSnackBar("Hello World!!!"))
        }
    }

    sealed class ScreenEvents {
        data class ShowSnackBar(val message: String): ScreenEvents()
        data class Navigate(val route: String): ScreenEvents()
    }
}
