package com.example.luistovar.archapp.framework.network.webservices

import com.example.luistovar.archapp.domain.models.PeopleListSw
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {

    @GET("people/")
    suspend fun getPeopleListSw(): Response<PeopleListSw>
}