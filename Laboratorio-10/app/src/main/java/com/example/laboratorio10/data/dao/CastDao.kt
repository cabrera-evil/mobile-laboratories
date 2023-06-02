package com.example.laboratorio10.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.laboratorio10.data.model.CastModel

@Dao
interface CastDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(casting: CastModel)
}