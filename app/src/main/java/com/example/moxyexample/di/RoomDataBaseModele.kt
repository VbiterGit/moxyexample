package com.example.moxyexample.di

import androidx.room.Room
import com.example.moxyexample.room.database.SchoolsDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomDatabaseModule = module {
    single{
        Room.databaseBuilder(
            androidContext(),
            SchoolsDataBase::class.java,
            "SchoolDataBase.db")
        .build()
    }
}