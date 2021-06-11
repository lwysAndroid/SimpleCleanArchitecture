package com.example.luistovar.archapp.data.datasources

import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwDataSource {

    suspend fun getPeopleListSW(): PeopleListSw?

    suspend fun getPeopleListSwResource(): Resource<PeopleListSw?>
}