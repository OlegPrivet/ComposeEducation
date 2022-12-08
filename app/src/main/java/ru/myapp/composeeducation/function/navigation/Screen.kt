package ru.myapp.composeeducation.function.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")

    fun withArgs(vararg args: String): String { // todo для обязательных аргументов с определнным порядком
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
