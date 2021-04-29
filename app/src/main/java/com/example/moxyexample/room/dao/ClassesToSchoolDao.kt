package com.example.moxyexample.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.moxyexample.room.entities.ClassesToSchool

@Dao
interface ClassesToSchoolDao: BaseDao<ClassesToSchool> {
    @Query("SELECT * FROM classes_to_school")
    fun getAllClassToSchools(): List<ClassesToSchool>
}