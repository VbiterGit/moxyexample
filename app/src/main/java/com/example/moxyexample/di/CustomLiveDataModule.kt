package com.example.moxyexample.di

import com.example.moxyexample.toolkit.livedata.CustomLiveData
import org.koin.dsl.module

val customLiveDataModule = module {
    single { CustomLiveData() }
}