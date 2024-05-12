package com.example.starwarsapp.base.presentation.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.starwarsapp.base.presentation.model.NavigationBarRoute
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBar
import com.example.starwarsapp.characters.presentation.view.CharactersScreen
import com.example.starwarsapp.chronology.presentation.view.ChronologyScreen
import com.example.starwarsapp.movies.presentation.view.MoviesScreen
import com.example.starwarsapp.trivia.presentation.view.TriviaScreen

@Composable
internal fun MainScreen() {

    val navController = rememberNavController()
    val selectedRoute = NavigationBarRoute.getRoute(navController.currentBackStackEntryAsState().value?.destination?.route)

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedRoute = selectedRoute,
                onItemClicked = { route -> navigateTo(navController, route) }
            )
        },
        content = { paddingValues ->
            MainScreenContainer(navController, paddingValues)
        }
    )
}

@Composable
fun MainScreenContainer(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = NavigationBarRoute.defaultRoute.value,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(NavigationBarRoute.MOVIES.value) { MoviesScreen() }
        composable(NavigationBarRoute.CHARACTERS.value) { CharactersScreen() }
        composable(NavigationBarRoute.CHRONOLOGY.value) { ChronologyScreen() }
        composable(NavigationBarRoute.TRIVIA.value) { TriviaScreen() }
    }
}

private fun navigateTo(navController: NavHostController, route: String) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
