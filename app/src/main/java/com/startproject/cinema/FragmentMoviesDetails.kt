package com.startproject.cinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.startproject.cinema.data.models.Actor
import com.startproject.cinema.domain.ActorsDataSource


class FragmentMoviesDetails: Fragment() {

    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        recycler?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recycler = view.findViewById(R.id.rv_actors)
        recycler?.adapter = ActorsAdapter(actorClickListener)

    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData(){
        (recycler?.adapter as? ActorsAdapter)?.run {
            bindActors(ActorsDataSource().getActors())
        }
    }

    private val actorClickListener = object : ActorListClickListener {
        override fun onClick(actor: Actor) {
//            requireActivity().supportFragmentManager.beginTransaction()
//                .addToBackStack(null)
////                .replace(R.id.main_container, FragmentMoviesDetails())
//                .commit()
        }
    }

}
