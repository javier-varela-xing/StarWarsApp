package com.example.starwarsapp.base.presentation.view.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.starwarsapp.base.presentation.model.DEFAULT_ROUTE
import com.example.starwarsapp.base.presentation.model.NavigationBarRoute

internal class BottomNavigationBarScreenshotTest {

    @Preview
    @Composable
    fun BottomNavigationBarDefaultRouteSelectedPreview() {
        BottomNavigationBar(
            selectedRoute = DEFAULT_ROUTE,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarMoviesSelectedPreview() {
        BottomNavigationBar(
            selectedRoute = NavigationBarRoute.MOVIES,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarCharactersSelectedPreview() {
        BottomNavigationBar(
            selectedRoute = NavigationBarRoute.CHARACTERS,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarChronologySelectedPreview() {
        BottomNavigationBar(
            selectedRoute = NavigationBarRoute.CHRONOLOGY,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarTriviaSelectedPreview() {
        BottomNavigationBar(
            selectedRoute = NavigationBarRoute.TRIVIA,
            onItemClicked = {}
        )
    }
}