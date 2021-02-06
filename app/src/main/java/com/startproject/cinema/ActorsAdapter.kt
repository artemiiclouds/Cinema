package com.startproject.cinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.startproject.cinema.data.models.Actor

class ActorsAdapter(
    private var listener: ActorListClickListener
): RecyclerView.Adapter<ActorsViewHolder>() {

    private var actors = listOf<Actor>()

    override fun getItemCount(): Int = actors.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return DataActorViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        when(holder) {
            is DataActorViewHolder -> {
                holder.onBind(actors[position])
                holder.itemView.setOnClickListener { listener.onClick(actors[position]) }
            }
        }
    }

    fun bindActors(newActors: List<Actor>) {
        actors = newActors
//        notifyDataSetChanged()
    }
}

abstract class ActorsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

class DataActorViewHolder(itemView: View): ActorsViewHolder(itemView) {
    private val name: TextView? = itemView.findViewById(R.id.tvActor1)
    private val avatar: ImageView? = itemView.findViewById(R.id.ivActor1)

    fun onBind(actor: Actor){
        name?.text = actor.name
        avatar?.setBackgroundResource(actor.imagePhoto)
    }
}

interface ActorListClickListener {
    fun onClick(actor: Actor)
}
