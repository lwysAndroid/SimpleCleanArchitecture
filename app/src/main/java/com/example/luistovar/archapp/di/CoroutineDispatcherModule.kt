package com.example.luistovar.archapp.di

import com.example.luistovar.archapp.presentation.commons.CoroutineDispatcherProvider
import com.example.luistovar.archapp.presentation.commons.CoroutineDispatcherProviderApp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CoroutineDispatcherModule {

    @Binds
    abstract fun bindCoroutineDispatcherProvider(
        coroutineDispatcherProvider: CoroutineDispatcherProviderApp
    ): CoroutineDispatcherProvider
}