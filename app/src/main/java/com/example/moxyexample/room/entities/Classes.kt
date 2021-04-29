package com.example.moxyexample.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moxyexample.room.tables.CLASSES

@Entity(tableName = CLASSES)
data class Classes(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "classes_number") var classesNumber: Int?,
    @ColumnInfo(name = "classes_letter") var classesLetter: String?
)