package com.hyzoka.kinomap.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


@Immutable
data class Palette(
    val grey100: Color,
    val blue100: Color,
)

val palette = Palette(grey100 = Color(0xFFB6C1C1), blue100 = Color(0xFF2993E1))