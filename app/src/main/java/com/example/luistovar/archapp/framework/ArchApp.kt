package com.example.luistovar.archapp.framework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * ArchApp
 *
 * Application class to set the custom configuration of the app
 */
@HiltAndroidApp
class ArchApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupApp()
    }

    /**
     * Method to set the init configuration of the app
     */
    private fun setupApp(){
        Timber.plant(Timber.DebugTree())
    }

}