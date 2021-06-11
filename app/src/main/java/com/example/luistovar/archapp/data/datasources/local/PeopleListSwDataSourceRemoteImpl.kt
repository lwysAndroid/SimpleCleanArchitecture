package com.example.luistovar.archapp.data.datasources.local

import com.example.luistovar.archapp.androidframework.network.webservices.StarWarsApi
import com.example.luistovar.archapp.data.datasources.PeopleListSwDataSource
import com.example.luistovar.archapp.domain.models.PeopleListSw
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
}