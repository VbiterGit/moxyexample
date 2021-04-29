package com.example.moxyexample.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.moxyexample.room.entities.Director
import com.example.moxyexample.room.entities.DirectorNames
import com.example.moxyexample.room.entities.SchoolsDirectors

@Dao
interface DirectorDao: BaseDao<Director> {
    @Query("SELECT * FROM director")
    fun getAllDirectors(): List<Director>

    @Query("SELECT first_name, last_name FROM director")
    fun getDirectorNames(): List<DirectorNames>

    @Transaction
    @Query("SELECT * FROM director")
    fun getSchoolsDirector(): List<SchoolsDirectors>
}