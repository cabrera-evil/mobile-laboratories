package com.example.laboratorio10.ui.movie.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio10.data.model.ActorModel
import com.example.laboratorio10.databinding.ActorItemBinding

class CastRecyclerViewHolder(private val binding: ActorItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(actor: ActorModel) {
        binding.actorNameTextView.text = actor.name
    }
}