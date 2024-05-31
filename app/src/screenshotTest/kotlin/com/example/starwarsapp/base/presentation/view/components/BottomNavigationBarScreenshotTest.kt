package com.example.starwarsapp.base.presentation.view.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import com.example.starwarsapp.base.presentation.model.DEFAULT_SELECTED_ITEM

internal class BottomNavigationBarScreenshotTest {

    @Preview
    @Composable
    fun BottomNavigationBarDefaultRouteSelectedPreview() {
        BottomNavigationBar(
            selectedItem = DEFAULT_SELECTED_ITEM,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarMoviesSelectedPreview() {
        BottomNavigationBar(
            selectedItem = BottomNavigationBarItem.Movies,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarCharactersSelectedPreview() {
        BottomNavigationBar(
            selectedItem = BottomNavigationBarItem.Movies,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarChronologySelectedPreview() {
        BottomNavigationBar(
            selectedItem = BottomNavigationBarItem.Chronology,
            onItemClicked = {}
        )
    }

    @Preview
    @Composable
    fun BottomNavigationBarTriviaSelectedPreview() {
        BottomNavigationBar(
            selectedItem = BottomNavigationBarItem.Trivia,
            onItemClicked = {}
        )
    }
}