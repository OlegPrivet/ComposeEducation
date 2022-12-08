package ru.myapp.composeeducation.enum

import java.util.*

enum class AvailableLocale(val locale: Locale) {
    RU(Locale("ru")),
    AZ(Locale("az")),
    TK(Locale("tk")),
    HY(Locale("hy")),
    KY(Locale("ky")),
    EN(Locale.ENGLISH)
}
