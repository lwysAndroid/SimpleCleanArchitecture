package com.example.luistovar.archapp.data.repositories

import com.example.luistovar.archapp.domain.models.PeopleSWDomain

interface PeopleListSwRepository {

    suspend fun getPeopleListSwResource(): PeopleSWDomain

}