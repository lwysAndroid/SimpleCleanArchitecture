package com.example.luistovar.archapp.data.repositories

import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwRepository {

    suspend fun getPeopleListSwResource(): Resource<PeopleListSw?>

}