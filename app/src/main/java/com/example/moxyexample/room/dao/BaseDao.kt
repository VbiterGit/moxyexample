package com.example.moxyexample.room.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BaseDao<T> {
    @Insert(onConflict = ABORT)
    fun insert(item: T)

    @Insert(onConflict = ABORT)
    fun insertAll(vararg items: T)

    @Update(onConflict = REPLACE)
    fun update(item: T)

    @Update(onConflict = REPLACE)
    fun updateAll(vararg items: T)

    @Delete
    fun delete(item: T)

    @Delete
    fun deleteAll(vararg items: T)
}