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
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.starwarsapp.base.presentation.model.BottomNavigationBarItem
import com.example.starwarsapp.base.presentation.model.DEFAULT_SELECTED_ITEM
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_ICON_PREFIX
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_LABEL_PREFIX
import com.example.starwarsapp.base.presentation.view.components.BottomNavigationBarTestTag.ITEM_PREFIX

val DrawableResourceId = SemanticsPropertyKey<Int>("DrawableResourceId")
var SemanticsPropertyReceiver.iconResourceId by DrawableResourceId

@Composable
internal fun BottomNavigationBar(
    selectedItem: BottomNavigationBarItem,
    onItemClicked: (route: String) -> Unit
) {
    NavigationBar {
        BottomNavigationBarItem.entries.forEach { item ->
            NavigationBarItem(
                modifier = Modifier.testTag(ITEM_PREFIX + item.navigationBarRoute.value),
                icon = {
                    val iconResId = getNavigationBarItemIcon(selectedItem, item)
                    Icon(
                        modifier = Modifier
                            .testTag(ITEM_ICON_PREFIX + item.navigationBarRoute.value)
                            .semantics { iconResourceId = iconResId },
                        painter = painterResource(id = iconResId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        modifier = Modifier.testTag(ITEM_LABEL_PREFIX + item.navigationBarRoute.value),
                        text = "Hola"
                    )
                },
                selected = false,
                onClick = { onItemClicked(item.navigationBarRoute.value) }
            )
        }
    }
}

private fun getNavigationBarItemIcon(
    selectedItem: BottomNavigationBarItem,
    navigationBarItem: BottomNavigationBarItem
): Int {
    return if (selectedItem.navigationBarRoute.value == navigationBarItem.navigationBarRoute.value) {
        navigationBarItem.selectedIcon
    } else {
        navigationBarItem.notSelectedIcon
    }
}

internal object BottomNavigationBarTestTag {

    const val ITEM_PREFIX = "BottomNavigationBarItem_"
    const val ITEM_LABEL_PREFIX = "BottomNavigationBarItemLabel_"
    const val ITEM_ICON_PREFIX = "BottomNavigationBarItemIcon_"
}

@Preview
@Composable
internal fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        selectedItem = DEFAULT_SELECTED_ITEM,
        onItemClicked = {}
    )
}
