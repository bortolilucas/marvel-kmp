package br.com.marvelkmp.app

import android.app.Application
import di.initKoin
import logging.util.initNapier
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@MainApplication)
        }
        initNapier()
    }
}