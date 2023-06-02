package com.example.laboratorio10.repositories

import com.example.laboratorio10.data.dao.ActorDao
import com.example.laboratorio10.data.model.ActorModel

class ActorRepository(private val actorDao: ActorDao) {

    suspend fun getAllActors() = actorDao.getAllActors()

    suspend fun addActor(actor: ActorModel) = actorDao.insertActor(actor)
}