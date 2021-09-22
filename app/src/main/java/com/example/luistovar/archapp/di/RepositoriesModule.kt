package com.example.luistovar.archapp.di

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.data.repositories.implementation.PeopleListSwRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindPeopleListSwRepository(
        peopleListSwRepositoryImpl: PeopleListSwRepositoryImpl
    ): PeopleListSwRepository
}