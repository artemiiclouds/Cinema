package com.startproject.cinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.startproject.cinema.data.models.Movie


class MovieAdapter(
        private var listener: MovieListClickListener
): RecyclerView.Adapter<MovieViewHolder>() {

    private var movies = listOf<Movie>()

    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return DataViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        when(holder) {
            is DataViewHolder -> {
                holder.onBind(movies[position])
                holder.itemView.setOnClickListener { listener.onClick(movies[position]) }
            }
        }
    }

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
//        notifyDataSetChanged()
    }
}

abstract class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

private class DataViewHolder(itemView: View) : MovieViewHolder(itemView) {
    private val avatar: ImageView? = itemView.findViewById(R.id.ivPosterCard1)
    private val name: TextView? = itemView.findViewById(R.id.tvTitleCard)
    private val genre: TextView? = itemView.findViewById(R.id.tvGenre)
    private val ageLimit: TextView? = itemView.findViewById(R.id.tvAge)
    private val duration: TextView? = itemView.findViewById(R.id.tvTimeDuration)
    private val like: ImageView? = itemView.findViewById(R.id.ivLike)


    fun onBind(movie: Movie){
        name?.text = movie.title
        genre?.text = movie.genres
        avatar?.setBackgroundResource(movie.imagePoster)
        ageLimit?.text = movie.toStringAgeLimit()
        duration?.text = movie.toStringDuration()

        if (movie.isFavourite) {
            like?.setBackgroundResource(R.drawable.like_icon_red)
        } else {
            like?.setBackgroundResource(R.drawable.like_icon_white)
        }
    }
}

interface MovieListClickListener {
    fun onClick(movie: Movie)
}

//private const val VIEW_TYPE_EMPTY = 0
//private const val VIEW_TYPE_MOVIES = 1





