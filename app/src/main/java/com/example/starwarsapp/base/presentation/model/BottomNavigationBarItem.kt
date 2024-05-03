package com.example.starwarsapp.base.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.starwarsapp.R
import com.example.starwarsapp.base.navigation.AppRoute

internal enum class BottomNavigationBarItem(
    @StringRes val text: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val notSelectedIcon: Int,
    val appRoute: AppRoute
) {

    Movies(
        text = R.string.movies,
        selectedIcon = R.drawable.ic_filled_movie,
        notSelectedIcon = R.drawable.ic_outlined_movie,
        appRoute = AppRoute.MOVIES
    ),
    Characters(
        text = R.string.characters,
        selectedIcon = R.drawable.ic_filled_character,
        notSelectedIcon = R.drawable.ic_outlined_character,
        appRoute = AppRoute.CHARACTERS
    ),
    Chronology(
        text = R.string.chronology,
        selectedIcon = R.drawable.ic_filled_clock,
        notSelectedIcon = R.drawable.ic_outlined_clock,
        appRoute = AppRoute.CHRONOLOGY
    ),
    Trivia(
        text = R.string.trivia,
        selectedIcon = R.drawable.ic_filled_trivia,
        notSelectedIcon = R.drawable.ic_outlined_trivia,
        appRoute = AppRoute.TRIVIA
    )
}
