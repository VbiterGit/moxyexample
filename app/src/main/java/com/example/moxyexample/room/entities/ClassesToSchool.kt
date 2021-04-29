package com.example.moxyexample.room.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.example.moxyexample.room.tables.CLASSES_TO_SCHOOL

@Entity(
    tableName = CLASSES_TO_SCHOOL,
    foreignKeys = [
        ForeignKey(
            entity = School::class,
            parentColumns = ["id"],
            childColumns = ["id_school"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(
            entity = Classes::class,
            parentColumns = ["id"],
            childColumns = ["id_classes"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ],
    indices = [
        Index("id_school", unique = true),
        Index( "id_classes", unique = true)
    ]
)
data class ClassesToSchool(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "id_school") var idSchool: Long,
    @ColumnInfo(name = "id_classes") var idClasses: Long,
)