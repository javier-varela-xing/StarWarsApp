package com.example.starwarsapp.base.presentation.view.components

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_ICON_PREFIX
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_LABEL_PREFIX
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_PREFIX

internal class BottomNavigationBarPageObject(
    private val composeTestRule: ComposeTestRule,
    private val context: Context
) {

    fun assertNavigationBarItemText(item: BottomNavigationBarItem) {
        composeTestRule
            .onNodeWithTag(ITEM_LABEL_PREFIX + item.navigationBarRoute.value, useUnmergedTree = true)
            .assertTextEquals(context.getString(item.text))
    }

    fun assertNavigationBarItemIcon(currentItem: BottomNavigationBarItem, item: BottomNavigationBarItem) {
        val icon = if (isSelectedIcon(currentItem, item)) item.selectedIcon else item.notSelectedIcon
        composeTestRule
            .onNodeWithTag(ITEM_ICON_PREFIX + item.navigationBarRoute.value, useUnmergedTree = true)
            .assert(hasDrawable(icon))
    }

    fun clickNavigationBarItem(navigationBarItem: BottomNavigationBarItem) {
        composeTestRule
            .onNodeWithTag(ITEM_PREFIX + navigationBarItem.navigationBarRoute.value)
            .performClick()
    }

    private fun hasDrawable(@DrawableRes id: Int): SemanticsMatcher =
        SemanticsMatcher.expectValue(DrawableResourceId, id)

    private fun isSelectedIcon(currentNavigationBarItem: BottomNavigationBarItem, item: BottomNavigationBarItem): Boolean =
        currentNavigationBarItem.navigationBarRoute.value == item.navigationBarRoute.value
}
