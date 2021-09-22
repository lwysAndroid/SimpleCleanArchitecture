package com.example.luistovar.archapp.di

import com.example.luistovar.archapp.data.datasources.remote.PeopleListSwRemoteDataSource
import com.example.luistovar.archapp.data.datasources.remote.impl.PeopleListSwRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteDataSourcesModule {

    @Binds
    abstract fun bindPeopleListSwDataSource(
        peopleListSwRemoteDataSourceImpl: PeopleListSwRemoteDataSourceImpl
    ): PeopleListSwRemoteDataSource
}