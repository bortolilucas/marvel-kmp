package br.com.marvelkmp.app

import android.app.Application
import di.initKoin
import logging.util.initNapier

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
        initNapier()
    }
}