package com.example.starwarsapp.base.presentation.model

internal sealed class NavigationBarRoute(val value: String) {

    data object MOVIES : NavigationBarRoute("Movies")
    data object CHARACTERS : NavigationBarRoute("Characters")
    data object CHRONOLOGY : NavigationBarRoute("Chronology")
    data object TRIVIA : NavigationBarRoute("Trivia")

    fun NavigationBarRoute.toBottomNavigationBarItem(): BottomNavigationBarItem {
        return when (this) {
            MOVIES -> BottomNavigationBarItem.Movies
            CHARACTERS -> BottomNavigationBarItem.Characters
            CHRONOLOGY -> BottomNavigationBarItem.Chronology
            TRIVIA -> BottomNavigationBarItem.Trivia
        }
    }

    companion object {

        fun getRoute(route: String?): NavigationBarRoute {
            return when (route) {
                MOVIES.value -> MOVIES
                CHARACTERS.value -> CHARACTERS
                CHRONOLOGY.value -> CHRONOLOGY
                TRIVIA.value -> TRIVIA
                else -> DEFAULT_SELECTED_ITEM.navigationBarRoute
            }
        }
    }
}
