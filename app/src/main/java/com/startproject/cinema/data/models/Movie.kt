package com.startproject.cinema.data.models

import android.widget.ImageView

data class Movie(
        val title: String,
        val genres: String,
        val imagePoster: Int,
        var ageLimit: Int,
        var duration: Int,
        var isFavourite: Boolean = false
//        val reviewsCount: Int,
//        val storyline: String,
//
//        val posterSmall: Int,
//        val posterBig: Int?,
//        val actors: List<Actor>?
        ) {
        fun toStringDuration(): String {
                return "$duration MIN"
        }

        fun toStringAgeLimit(): String {
                return "$ageLimit+"
        }
}