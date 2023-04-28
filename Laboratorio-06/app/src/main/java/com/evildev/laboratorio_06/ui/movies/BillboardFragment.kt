package com.evildev.laboratorio_06.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.evildev.laboratorio_06.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var cardViewStarWars: CardView
    private lateinit var cardViewHarryPotter: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    //    Adding fragment listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionNavToCreateMovie = view.findViewById(R.id.action_to_create_movie)
        cardViewStarWars = view.findViewById(R.id.cardView_star_wars)
        cardViewHarryPotter = view.findViewById(R.id.cardView_harry_potter)

        cardViewStarWars.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        cardViewHarryPotter.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        actionNavToCreateMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_createFragment)
        }
    }
}