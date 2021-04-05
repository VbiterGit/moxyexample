package com.example.budgetplanner

import android.app.Application
import com.example.budgetplanner.di.moxyImageModule
import com.example.budgetplanner.di.moxyRvModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                listOf(
                    moxyImageModule,
                    moxyRvModule
                )
            )
        }
    }
}