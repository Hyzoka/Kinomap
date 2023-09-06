package com.hyzoka.kinomap.model

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon

data class Voiture(
    val id: Int,
    val name: String,
    val training: String?,
    val icon: Icons,
)