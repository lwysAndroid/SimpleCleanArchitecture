package com.example.luistovar.archapp.data.repositories.implementation

import com.example.luistovar.archapp.data.datasources.PeopleListSwDataSource
import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleListSw

class PeopleListSwRepositoryImpl(private val remoteDataSource: PeopleListSwDataSource) :
    PeopleListSwRepository {

    override suspend fun getPeopleListSW(): PeopleListSw? =
        remoteDataSource.getPeopleListSW()

}