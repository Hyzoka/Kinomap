package com.hyzoka.kinomap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.hyzoka.kinomap.navigation.NavGraph
import com.hyzoka.kinomap.ui.theme.KinomapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KinomapTheme {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MainScreen() {
    KinomapTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}