package com.example.luistovar.archapp.data.datasources.remote

import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwRemoteDataSource {

    suspend fun getPeopleListSwResource(): Resource<PeopleListSw?>
}