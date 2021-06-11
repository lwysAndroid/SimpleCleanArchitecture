package com.example.luistovar.archapp

import android.app.Application
import com.example.luistovar.archapp.androidframework.network.NetWorkConfiguration

class ArchApp : Application() {

    val netWorkConfiguration = NetWorkConfiguration()
    override fun onCreate() {
        super.onCreate()

    }
}