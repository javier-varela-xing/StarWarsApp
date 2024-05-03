package com.example.starwarsapp.base.presentation.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.starwarsapp.base.navigation.AppRoute
import com.example.starwarsapp.base.navigation.AppRoute.CHARACTERS.defaultRoute
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import com.example.starwarsapp.characters.presentation.view.CharactersScreen
import com.example.starwarsapp.chronology.presentation.view.ChronologyScreen
import com.example.starwarsapp.movies.presentation.view.MoviesScreen
import com.example.starwarsapp.trivia.presentation.view.TriviaScreen

@Composable
internal fun MainScreen() {

    val navController = rememberNavController()
    val selectedRoute = AppRoute.getRoute(navController.currentBackStackEntryAsState().value?.destination?.route)

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
private fun BottomNavigationBar(
    selectedRoute: AppRoute,
    onItemClicked: (route: String) -> Unit
) {
    NavigationBar {
        BottomNavigationBarItem.entries.forEach { item ->
            NavigationBarItem(
                icon = {
                    val icon = if (selectedRoute.value == item.appRoute.value) item.selectedIcon else item.notSelectedIcon
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = item.text)) },
                selected = false,
                onClick = { onItemClicked(item.appRoute.value) }
            )
        }
    }
}

@Composable
private fun MainScreenContainer(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = defaultRoute.value,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(AppRoute.MOVIES.value) { MoviesScreen() }
        composable(AppRoute.CHARACTERS.value) { CharactersScreen() }
        composable(AppRoute.CHRONOLOGY.value) { ChronologyScreen() }
        composable(AppRoute.TRIVIA.value) { TriviaScreen() }
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
