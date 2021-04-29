package com.example.moxyexample.room.entities

import androidx.room.*
//import androidx.room.ForeignKey.CASCADE
import com.example.moxyexample.room.tables.SCHOOL

@Entity(
    tableName = SCHOOL,
//    foreignKeys = [
//        ForeignKey(
//            entity = Director::class,
//            parentColumns = ["id"],
//            childColumns = ["id_director"],
//            onDelete = CASCADE,
//            onUpdate = CASCADE
//        )
//    ],
    indices = [Index("id_director", unique = true)]
)
data class School(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "school_number") var schoolNumber: Int?,
    @ColumnInfo(name = "school_name") var schoolName: String?,
    @ColumnInfo(name = "id_director") var idDirector: Long?,
)