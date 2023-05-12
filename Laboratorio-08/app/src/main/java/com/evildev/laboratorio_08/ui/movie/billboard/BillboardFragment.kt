package com.evildev.laboratorio_08.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.evildev.laboratorio_08.R
import com.evildev.laboratorio_08.data.MovieModel
import com.evildev.laboratorio_08.databinding.FragmentBillboardBinding
import com.evildev.laboratorio_08.databinding.FragmentNewMovieBinding
import com.evildev.laboratorio_08.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.evildev.laboratorio_08.ui.movie.viewmodel.MovieViewModel

class BillboardFragment : Fragment() {
    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: MovieRecyclerViewAdapter
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        view?.findNavController()?.navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view:View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter(){
            selectMovie -> showSelectedItem(selectMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    //    Adding fragment listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.actionToCreateMovie.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_createFragment)
        }
    }
}