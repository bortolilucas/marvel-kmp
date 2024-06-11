package br.com.marvelkmp.app

import android.app.Application
import br.com.marvelkmp.logging.util.initNapier
import di.initKoin
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