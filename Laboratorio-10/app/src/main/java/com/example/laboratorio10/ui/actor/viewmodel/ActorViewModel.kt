package com.example.laboratorio10.ui.actor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio10.MovieReviewerApplication
import com.example.laboratorio10.data.model.ActorModel
import com.example.laboratorio10.repositories.ActorRepository
import kotlinx.coroutines.launch

class ActorViewModel(private val repository: ActorRepository) : ViewModel() {
    var name = MutableLiveData("")
    var status = MutableLiveData("")

    suspend fun getAllActors() = repository.getAllActors()

    private fun addActor(actor: ActorModel) {
        viewModelScope.launch {
            repository.addActor(actor)
        }
    }

    fun createActor() {
        if (name.value!!.isNotEmpty()) {
            addActor(ActorModel(name.value!!))
            status.value = ACTOR_CREATED
            name.value = ""
        } else {
            status.value = WRONG_INFORMATION
        }
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app =
                    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        const val ACTOR_CREATED = "Actor created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}