package com.example.luistovar.archapp.data.datasources.remote.impl

import com.example.luistovar.archapp.framework.network.webservices.api.StarWarsApi
import com.example.luistovar.archapp.data.datasources.remote.PeopleListSwRemoteDataSource
import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSwResponse
import javax.inject.Inject

class PeopleListSwRemoteDataSourceImpl @Inject constructor(
    private val sarWarsApi: StarWarsApi
) :
    PeopleListSwRemoteDataSource {


    override suspend fun getPeopleListSwResource(): PeopleListSwResponse? {
        val response = sarWarsApi.getPeopleListSw()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}