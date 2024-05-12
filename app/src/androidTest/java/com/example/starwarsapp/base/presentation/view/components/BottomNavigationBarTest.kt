package com.example.starwarsapp.base.presentation.view.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import com.example.starwarsapp.base.presentation.model.NavigationBarRoute
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_PREFIX
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Enclosed::class)
internal class BottomNavigationBarTest {

    @RunWith(Parameterized::class)
    class BottomNavigationBarCallbackTest(private val selectedRoute: NavigationBarRoute) {

        @get:Rule val composeTestRule = createComposeRule()

        @Test
        fun shouldCallOnItemClickedCallbackWhenClickingOnBottomNavigationBarItem() {
            lateinit var clickedRoute: String
            composeTestRule.setContent {
                BottomNavigationBar(
                    selectedRoute = selectedRoute,
                    onItemClicked = { route -> clickedRoute = route }
                )
            }

            composeTestRule
                .onNodeWithTag(ITEM_PREFIX + selectedRoute.value)
                .performClick()

            assert(selectedRoute.value == clickedRoute)
        }

        companion object {

            @JvmStatic @Parameterized.Parameters
            fun parameters() = BottomNavigationBarItem.entries.map { it.navigationBarRoute }
        }
    }
}
