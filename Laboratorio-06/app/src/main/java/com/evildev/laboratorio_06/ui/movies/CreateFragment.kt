package com.evildev.laboratorio_06.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.evildev.laboratorio_06.R
import com.evildev.laboratorio_06.data.Movie
import com.google.android.material.textfield.TextInputLayout

class CreateFragment : Fragment() {
    private lateinit var nameInput: TextInputLayout
    private lateinit var categoryInput: TextInputLayout
    private lateinit var descriptionInput: TextInputLayout
    private lateinit var qualificationInput: TextInputLayout
    private lateinit var submitButton: Button

    private val viewModel: MoviesViewModel  by activityViewModels {
        MoviesViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    //Adding fragment listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Binding form elements
        binding()

        //Adding listener to submit button
        submitButton.setOnClickListener {
            createMovie()
        }
    }

    //Binding form elements
    private fun binding() {
        nameInput = view?.findViewById(R.id.name_input)!!
        categoryInput = view?.findViewById(R.id.category_input)!!
        descriptionInput = view?.findViewById(R.id.description_input)!!
        qualificationInput = view?.findViewById(R.id.qualification_input)!!
        submitButton = view?.findViewById(R.id.submit_button)!!
    }

    //Create a new movie
//Create a new movie
    private fun createMovie() {
        val name = nameInput.editText?.text.toString()
        val category = categoryInput.editText?.text.toString()
        val description = descriptionInput.editText?.text.toString()
        val qualification = qualificationInput.editText?.text.toString()

        if (name.isEmpty() || category.isEmpty() || description.isEmpty() || qualification.isEmpty())
            return

        val movie = Movie(name, category, description, qualification)
        viewModel.addMovie(movie)
        Log.d("CreateFragment", "Movie created: $movie")
        findNavController().popBackStack()
    }
}