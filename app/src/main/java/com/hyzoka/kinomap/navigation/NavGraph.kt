package com.hyzoka.kinomap.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hyzoka.kinomap.model.*
import com.hyzoka.kinomap.utils.network.ScreenState
import com.hyzoka.kinomap.view.*
import com.hyzoka.kinomap.view.detail.DetailVoitureScreen
import com.hyzoka.kinomap.view.error.ErrorRetrievingVoitureScreen
import com.hyzoka.kinomap.viewmodel.VoitureViewModel
import org.koin.androidx.compose.getViewModel

private var openVoiture: Voiture? = null

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeScreen.Start.name
    ) {
        composable(route = HomeScreen.Start.name) {
            HomeRoute(navController)
        }
        composable(route = HomeScreen.Detail.name) {
            DetailRoute(voiture = requireNotNull(openVoiture), navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeRoute(
    navController: NavHostController
) {

    val voitureViewModel: VoitureViewModel = getViewModel()
    val screenState by voitureViewModel.screenState.collectAsState()
    val listVoiture by voitureViewModel.listVoitures.collectAsState(initial = emptyList())

    when (screenState) {
        ScreenState.Loading -> FullScreenCircularProgressBar()
        ScreenState.Error -> ErrorRetrievingVoitureScreen { voitureViewModel.fetchVoitures() }
        ScreenState.Success -> HomeScreen(listVoiture = listVoiture, onNewsClicked = { voiture ->
            openVoiture = voiture
            navController.navigate(HomeScreen.Detail.name)
        })
    }
}

@Composable
fun DetailRoute(voiture: Voiture, navController: NavHostController) {
    DetailVoitureScreen(voiture = voiture) {
        navController.popBackStack(HomeScreen.Start.name, false)
    }
}

enum class HomeScreen {
    Start,
    Detail,
}