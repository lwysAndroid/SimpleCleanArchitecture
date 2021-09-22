package com.example.luistovar.archapp.data.datasources.remote

import com.example.luistovar.archapp.data.datasources.remote.webservices.models.PeopleListSwResponse

interface PeopleListSwRemoteDataSource {

    suspend fun getPeopleListSwResource(): PeopleListSwResponse?
}