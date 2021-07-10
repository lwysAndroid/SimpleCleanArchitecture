package com.example.luistovar.archapp.usecases.implementation

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.usecases.PeopleListSwUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PeopleListSwUseCaseImpl @Inject constructor(
    private val peopleListSwRepository: PeopleListSwRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) :
    PeopleListSwUseCase {

    override suspend fun getPeopleListSwResource(): Resource<PeopleListSw?> =
        withContext(coroutineDispatcher) {
            peopleListSwRepository.getPeopleListSwResource()
        }

}