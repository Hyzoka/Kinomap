package com.hyzoka.kinomap.utils.network

import com.hyzoka.kinomap.model.Voiture

sealed class ScreenState {
    object Loading : ScreenState()
    object Error : ScreenState()
    object Success : ScreenState()
}