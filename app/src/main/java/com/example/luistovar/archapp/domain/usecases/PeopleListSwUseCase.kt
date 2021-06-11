package com.example.luistovar.archapp.domain.usecases

import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource

interface PeopleListSwUseCase {

    suspend fun getPeopleListSW(): PeopleListSw?

    suspend fun getPeopleListSwResource(): Resource<PeopleListSw?>


}