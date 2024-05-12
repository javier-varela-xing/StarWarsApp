package com.example.starwarsapp.base.presentation.view

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_PREFIX
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MainScreenTest {

    @get:Rule val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainScreen()
        }
    }

    @Test
    fun shouldShowMoviesScreenAsStartDestination() {
        composeTestRule
            .onNodeWithText("Movies Screen")
            .assertIsDisplayed()
    }

    @Test
    fun whenClickingMoviesIconInBottomNavigationBarShouldNavigateToMoviesScreen() {
        composeTestRule
            .onNodeWithTag(ITEM_PREFIX + "Characters")
            .performClick()
        composeTestRule
            .onNodeWithTag(ITEM_PREFIX + "Movies")
            .performClick()
        composeTestRule
            .onNodeWithText("Movies Screen")
            .assertIsDisplayed()
    }

    @Test
    fun whenClickingCharactersIconInBottomNavigationBarShouldNavigateToCharactersScreen() {
        composeTestRule
            .onNodeWithTag(ITEM_PREFIX + "Characters")
            .performClick()
        composeTestRule
            .onNodeWithText("Characters Screen")
            .assertIsDisplayed()
    }

    @Test
    fun whenClickingChronologyIconInBottomNavigationBarShouldNavigateToChronologyScreen() {
        composeTestRule
            .onNodeWithTag(ITEM_PREFIX + "Chronology")
            .performClick()
        composeTestRule
            .onNodeWithText("Chronology Screen")
            .assertIsDisplayed()
    }

    @Test
    fun whenClickingTriviaIconInBottomNavigationBarShouldNavigateToTriviaScreen() {
        composeTestRule
            .onNodeWithTag(ITEM_PREFIX + "Trivia")
            .performClick()
        composeTestRule
            .onNodeWithText("Trivia Screen")
            .assertIsDisplayed()
    }
}
