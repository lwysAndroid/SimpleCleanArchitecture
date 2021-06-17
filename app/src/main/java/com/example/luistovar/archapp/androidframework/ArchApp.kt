package com.example.luistovar.archapp.androidframework

import android.app.Application
import timber.log.Timber

class ArchApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}