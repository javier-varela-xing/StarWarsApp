package com.example.starwarsapp.base.presentation.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

internal class MainScreenPageObject(private val composeTestRule: ComposeTestRule) {

    fun assertText(text: String) {
        composeTestRule
            .onNodeWithText(text)
            .assertIsDisplayed()
    }

    fun performClick(tag: String) {
        composeTestRule
            .onNodeWithTag(tag)
            .performClick()
    }
}
