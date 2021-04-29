package com.example.moxyexample.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moxyexample.room.tables.DIRECTOR

@Entity (tableName = DIRECTOR)
data class Director(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "last_name") var lastName: String?,
    var patronymic: String?,
    @ColumnInfo(name = "full_name") var fullName: String?
)
