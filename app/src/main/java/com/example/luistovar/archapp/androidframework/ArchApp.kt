package com.example.luistovar.archapp.androidframework

import android.app.Application
import com.example.luistovar.archapp.androidframework.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
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
        setupKoin()
        Timber.plant(Timber.DebugTree())
    }

    /**
     * Method to setup dependency injection using Koin, in this
     * method all teh modules ara added
     */
    private fun setupKoin() {
        startKoin {
            androidContext(this@ArchApp)
            modules(listOf(
                appModule,
                networkModule,
                localDataSourceModule,
                remoteDataSourceModule,
                repositoryModule,
                useCasesModule,
                homeModule,
                listDataModule
            ))
        }
    }
}