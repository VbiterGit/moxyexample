package com.example.moxyexample.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moxyexample.room.dao.ClassesDao
import com.example.moxyexample.room.dao.ClassesToSchoolDao
import com.example.moxyexample.room.dao.DirectorDao
import com.example.moxyexample.room.dao.SchoolDao
import com.example.moxyexample.room.entities.Classes
import com.example.moxyexample.room.entities.ClassesToSchool
import com.example.moxyexample.room.entities.Director
import com.example.moxyexample.room.entities.School

@Database(entities = [ School::class, Classes::class, ClassesToSchool::class, Director::class ], version = 1)
abstract class SchoolsDataBase: RoomDatabase() {
    abstract fun schoolDao(): SchoolDao
    abstract fun classDao(): ClassesDao
    abstract fun directorDao(): DirectorDao
    abstract fun classesToSchoolDao(): ClassesToSchoolDao
}