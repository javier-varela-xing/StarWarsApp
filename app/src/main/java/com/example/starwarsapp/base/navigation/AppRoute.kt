package com.example.starwarsapp.base.navigation

import com.example.starwarsapp.base.navigation.AppRoute.CHARACTERS.defaultRoute

internal sealed class AppRoute(val value: String) {

    data object MOVIES : AppRoute("Movies")
    data object CHARACTERS : AppRoute("Characters")
    data object CHRONOLOGY : AppRoute("Chronology")
    data object TRIVIA : AppRoute("Trivia")

    val defaultRoute = MOVIES

    companion object {

        fun getRoute(route: String?): AppRoute {
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
