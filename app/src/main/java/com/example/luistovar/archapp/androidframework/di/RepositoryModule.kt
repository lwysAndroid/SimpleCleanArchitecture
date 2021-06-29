package com.example.luistovar.archapp.androidframework.di

import com.example.luistovar.archapp.data.datasources.remote.PeopleListSwDataSource
import com.example.luistovar.archapp.data.datasources.remote.impl.PeopleListSwDataSourceRemoteImpl
import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.data.repositories.implementation.PeopleListSwRepositoryImpl
import org.koin.dsl.module

val localDataSourceModule = module {

}

val remoteDataSourceModule = module {
    factory<PeopleListSwDataSource> { PeopleListSwDataSourceRemoteImpl(get()) }
}

val repositoryModule = module {
    factory<PeopleListSwRepository> { PeopleListSwRepositoryImpl(get()) }
}