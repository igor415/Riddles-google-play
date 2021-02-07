package com.varivoda.igor.zagonetke

import android.app.Application
import com.varivoda.igor.data.di.storageModule
import com.varivoda.igor.domain.di.interactionModule
import com.varivoda.igor.zagonetke.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.logger.Level

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) AndroidLogger() else EmptyLogger()
            AndroidLogger(Level.DEBUG)
            androidContext(this@App)

           modules(listOf(storageModule, interactionModule, appModule))
        }
    }
}