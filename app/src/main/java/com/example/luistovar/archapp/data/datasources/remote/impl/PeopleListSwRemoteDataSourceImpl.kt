package com.example.luistovar.archapp.data.datasources.remote.impl

import com.example.luistovar.archapp.framework.network.webservices.StarWarsApi
import com.example.luistovar.archapp.data.datasources.remote.PeopleListSwRemoteDataSource
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import java.lang.Exception
import javax.inject.Inject

class PeopleListSwRemoteDataSourceImpl @Inject constructor(
    private val sarWarsApi: StarWarsApi
) :
    PeopleListSwRemoteDataSource {


    override suspend fun getPeopleListSwResource(): Resource<PeopleListSw?> {
        return try {
            val response = sarWarsApi.getPeopleListSw()
            if (response.isSuccessful) {
                Resource.Success(response.body())
            } else {
                Resource.Error("Something went Wrong")
            }
        } catch (exception: Exception) {
            Resource.Error(exception.message ?: "Something went Wrong 2")
        }
    }
}