package com.example.luistovar.archapp.domain.usecases

import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwUseCase {

    suspend fun getPeopleListSwResource(): Resource<PeopleSWDomain>

}