package com.startproject.cinema.domain

import com.startproject.cinema.R
import com.startproject.cinema.data.models.Actor


class ActorsDataSource {
    fun getActors(): List<Actor> {
        return listOf(
                Actor("Robert\nDowney Jr.", R.drawable.actor1),
                Actor("Chris\nEvans", R.drawable.actor2),
                Actor("Mark\nRuffalo", R.drawable.actor3),
                Actor("Chris\nHemsworth", R.drawable.actor4)
        )
    }
}