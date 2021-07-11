package com.example.luistovar.archapp.data.datasources.remote

import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSwResponse

interface PeopleListSwRemoteDataSource {

    suspend fun getPeopleListSwResource(): PeopleListSwResponse?
}