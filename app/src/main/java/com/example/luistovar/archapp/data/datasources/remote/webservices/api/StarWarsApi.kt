package com.example.luistovar.archapp.data.datasources.remote.webservices.api

import com.example.luistovar.archapp.data.datasources.remote.webservices.models.PeopleListSwResponse
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {

    @GET("people/")
    suspend fun getPeopleListSw(): Response<PeopleListSwResponse>
}