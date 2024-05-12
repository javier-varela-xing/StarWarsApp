package com.example.starwarsapp.base.presentation.model

internal val DEFAULT_ROUTE = NavigationBarRoute.MOVIES

internal sealed class NavigationBarRoute(val value: String) {

    data object MOVIES : NavigationBarRoute("Movies")
    data object CHARACTERS : NavigationBarRoute("Characters")
    data object CHRONOLOGY : NavigationBarRoute("Chronology")
    data object TRIVIA : NavigationBarRoute("Trivia")

    companion object {

        fun getRoute(route: String?): NavigationBarRoute {
            return when (route) {
                MOVIES.value -> MOVIES
                CHARACTERS.value -> CHARACTERS
                CHRONOLOGY.value -> CHRONOLOGY
                TRIVIA.value -> TRIVIA
                else -> DEFAULT_ROUTE
            }
        }
    }
}
