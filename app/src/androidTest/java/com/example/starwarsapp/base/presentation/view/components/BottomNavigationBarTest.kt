package com.example.starwarsapp.base.presentation.view.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
internal class BottomNavigationBarTest(private val navigationBarItem: BottomNavigationBarItem) {

    @get:Rule val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val bottomNavigationBarPageObject = BottomNavigationBarPageObject(composeTestRule, context)
    private lateinit var clickedRoute: String

    @Before
    fun setUp() {
        composeTestRule.setContent {
            BottomNavigationBar(
                selectedItem = navigationBarItem,
                onItemClicked = { route -> clickedRoute = route }
            )
        }
    }

    @Test
    fun shouldRenderBottomNavigationBar() {
        bottomNavigationBarPageObject.assertNavigationBarItemText(navigationBarItem)
        BottomNavigationBarItem.entries.map { item ->
            bottomNavigationBarPageObject.assertNavigationBarItemIcon(navigationBarItem, item)
        }
    }

    @Test
    fun shouldCallOnItemClickedCallbackWhenClickingOnBottomNavigationBarItem() {
        bottomNavigationBarPageObject.clickNavigationBarItem(navigationBarItem)

        assert(navigationBarItem.navigationBarRoute.value == clickedRoute)
    }

    companion object {

        @JvmStatic @Parameterized.Parameters
        fun parameters() = BottomNavigationBarItem.entries
    }
}
