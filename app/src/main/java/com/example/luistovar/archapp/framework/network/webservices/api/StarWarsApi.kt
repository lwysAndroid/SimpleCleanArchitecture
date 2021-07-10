package com.example.luistovar.archapp.framework.network.webservices.api

import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSw
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {

    @GET("people/")
    suspend fun getPeopleListSw(): Response<PeopleListSw>
}