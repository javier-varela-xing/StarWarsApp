package com.example.starwarsapp.base.presentation.view

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_PREFIX
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController
    private val mainScreenPageObject = MainScreenPageObject(composeTestRule)

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
        mainScreenPageObject.assertText("Movies Screen")
    }

    @Test
    fun whenClickingMoviesIconInBottomNavigationBarShouldNavigateToMoviesScreen() {
        with(mainScreenPageObject) {
            performClick(ITEM_PREFIX + "Characters")
            performClick(ITEM_PREFIX + "Movies")
            assertText("Movies Screen")
        }
    }

    @Test
    fun whenClickingCharactersIconInBottomNavigationBarShouldNavigateToCharactersScreen() {
        with(mainScreenPageObject) {
            performClick(ITEM_PREFIX + "Characters")
            assertText("Characters Screen")
        }
    }

    @Test
    fun whenClickingChronologyIconInBottomNavigationBarShouldNavigateToChronologyScreen() {
        with(mainScreenPageObject) {
            performClick(ITEM_PREFIX + "Chronology")
            assertText("Chronology Screen")
        }
    }

    @Test
    fun whenClickingTriviaIconInBottomNavigationBarShouldNavigateToTriviaScreen() {
        with(mainScreenPageObject) {
            performClick(ITEM_PREFIX + "Trivia")
            assertText("Trivia Screen")
        }
    }
}
