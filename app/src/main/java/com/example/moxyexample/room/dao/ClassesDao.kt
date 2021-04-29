package com.example.moxyexample.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.moxyexample.room.entities.Classes

@Dao
interface ClassesDao: BaseDao<Classes> {
    @Query("SELECT * FROM classes")
    fun getAllClasses(): List<Classes>
}