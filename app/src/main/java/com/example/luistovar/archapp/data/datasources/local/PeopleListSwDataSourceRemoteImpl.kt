package com.example.luistovar.archapp.data.datasources.local

import com.example.luistovar.archapp.androidframework.network.webservices.StarWarsApi
import com.example.luistovar.archapp.data.datasources.PeopleListSwDataSource
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class PeopleListSwDataSourceRemoteImpl(private val sarWarsApi: StarWarsApi) :
    PeopleListSwDataSource {

    override suspend fun getPeopleListSW(): PeopleListSw? {
        val response = sarWarsApi.getPeopleListSw()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

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