package com.example.starwarsapp.base.presentation.model

internal sealed class NavigationBarRoute(val value: String) {

    data object MOVIES : NavigationBarRoute("Movies")
    data object CHARACTERS : NavigationBarRoute("Characters")
    data object CHRONOLOGY : NavigationBarRoute("Chronology")
    data object TRIVIA : NavigationBarRoute("Trivia")

    companion object {

        val defaultRoute = MOVIES

        fun getRoute(route: String?): NavigationBarRoute {
            return when (route) {
                MOVIES.value -> MOVIES
                CHARACTERS.value -> CHARACTERS
                CHRONOLOGY.value -> CHRONOLOGY
                TRIVIA.value -> TRIVIA
                else -> defaultRoute
            }
        }
    }
}
