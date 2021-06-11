package com.example.luistovar.archapp.domain.usecases.implementation

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase

class PeopleListSwUseCaseImpl(private val peopleListSwRepository: PeopleListSwRepository) :
    PeopleListSwUseCase {

    override suspend fun getPeopleListSW(): PeopleListSw? =
        peopleListSwRepository.getPeopleListSW()

    override suspend fun getPeopleListSwResource(): Resource<PeopleListSw?> =
        peopleListSwRepository.getPeopleListSwResource()

}