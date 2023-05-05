package com.evildev.laboratorio_07.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.evildev.laboratorio_07.databinding.FragmentNewMovieBinding

class NewMovieFragment : Fragment() {
    private lateinit var binding: FragmentNewMovieBinding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Adding fragment listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    private fun setObserver() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}
