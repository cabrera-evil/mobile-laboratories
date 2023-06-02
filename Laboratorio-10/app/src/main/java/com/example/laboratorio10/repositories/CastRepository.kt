package com.example.laboratorio10.repositories

import com.example.laboratorio10.data.dao.CastDao
import com.example.laboratorio10.data.model.CastModel

class CastRepository(private val castDao: CastDao) {

    suspend fun addCasting(casting: CastModel) = castDao.insert(casting)
}