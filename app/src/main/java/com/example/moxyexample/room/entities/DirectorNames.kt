package com.example.moxyexample.room.entities

import androidx.room.ColumnInfo

data class DirectorNames(
    @ColumnInfo(name = "first_name")var firstName: String?,
    @ColumnInfo(name = "last_name")var lastName: String?
)
