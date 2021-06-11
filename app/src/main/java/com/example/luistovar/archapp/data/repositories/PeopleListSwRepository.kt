package com.example.luistovar.archapp.data.repositories

import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwRepository {

    suspend fun getPeopleListSW(): PeopleListSw?

    suspend fun getPeopleListSwResource(): Resource<PeopleListSw?>

}