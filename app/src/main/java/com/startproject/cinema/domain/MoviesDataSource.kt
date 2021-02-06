package com.startproject.cinema.domain

import com.startproject.cinema.data.models.Movie
import com.startproject.cinema.R

class MoviesDataSource {
    fun getMovies(): List<Movie> {
        return listOf(
                Movie("Avengers: End Game", "Action, Adventure, Fantasy", R.drawable.avengers_mini_poster,13, 137),
                Movie("Tenet", "Action, Sci-Fi, Thriller", R.drawable.poster_tenet_new, 16, 97, true),
                Movie("Black Widow", "Action, Adventure, Sci-Fi", R.drawable.poster_black_widow_new, 13, 102),
                Movie("Wonder Woman 1984", "Action, Adventure, Fantasy", R.drawable.poster_wonder_woman_new, 13, 120)
        )
    }
}