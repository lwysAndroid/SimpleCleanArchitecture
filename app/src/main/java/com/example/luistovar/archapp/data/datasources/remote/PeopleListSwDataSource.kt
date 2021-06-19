package com.example.luistovar.archapp.data.datasources.remote

import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwDataSource {

    suspend fun getPeopleListSwResource(): Resource<PeopleListSw?>
}