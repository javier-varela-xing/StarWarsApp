package com.example.starwarsapp.base.presentation.view.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import com.example.starwarsapp.base.presentation.model.NavigationBarRoute
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_PREFIX

@Composable
internal fun BottomNavigationBar(
    selectedRoute: NavigationBarRoute,
    onItemClicked: (route: String) -> Unit
) {
    NavigationBar {
        BottomNavigationBarItem.entries.forEach { item ->
            NavigationBarItem(
                modifier = Modifier.testTag(ITEM_PREFIX + item.navigationBarRoute.value),
                icon = {
                    val icon = getNavigationBarItemIcon(selectedRoute, item)
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = item.text)) },
                selected = false,
                onClick = { onItemClicked(item.navigationBarRoute.value) }
            )
        }
    }
}

private fun getNavigationBarItemIcon(selectedRoute: NavigationBarRoute, navigationBarItem: BottomNavigationBarItem): Int {
    return if (selectedRoute.value == navigationBarItem.navigationBarRoute.value) {
        navigationBarItem.selectedIcon
    } else {
        navigationBarItem.notSelectedIcon
    }
}

internal object BottomNavigationBarTestTag {

    const val ITEM_PREFIX = "BottomNavigationBarItem_"
}
