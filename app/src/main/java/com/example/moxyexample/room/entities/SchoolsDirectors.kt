package com.example.moxyexample.room.entities

import androidx.room.Embedded
import androidx.room.Relation

data class SchoolsDirectors(
    @Embedded var director: Director,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_director"
    )
    val school: School
)