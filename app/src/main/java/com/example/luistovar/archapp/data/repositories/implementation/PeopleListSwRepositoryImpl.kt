package com.example.luistovar.archapp.data.repositories.implementation

import com.example.luistovar.archapp.data.datasources.remote.PeopleListSwRemoteDataSource
import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import javax.inject.Inject

class PeopleListSwRepositoryImpl @Inject constructor(
    private val remoteRemoteDataSource: PeopleListSwRemoteDataSource
) :
    PeopleListSwRepository {


    override suspend fun getPeopleListSwResource(): Resource<PeopleListSw?> =
        remoteRemoteDataSource.getPeopleListSwResource()

}