package com.startproject.cinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.startproject.cinema.data.models.Movie
import com.startproject.cinema.domain.MoviesDataSource

class FragmentMoviesList: Fragment() {

    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.rv_film_posters)
        recycler?.adapter = MovieAdapter(clickListener)
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData(){
        (recycler?.adapter as? MovieAdapter)?.run {
            bindMovies(MoviesDataSource().getMovies())
        }
    }

    private val clickListener = object : MovieListClickListener {
        override fun onClick(movie: Movie) {
            requireActivity().supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.main_container, FragmentMoviesDetails())
                    .commit()
        }
    }

}