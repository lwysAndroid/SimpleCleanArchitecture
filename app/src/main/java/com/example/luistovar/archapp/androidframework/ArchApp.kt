package com.example.luistovar.archapp.androidframework

import android.app.Application
import timber.log.Timber

/**
 * ArchApp
 *
 * Application class to set the custom configuration of the app
 */
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