package com.example.luistovar.archapp.domain.usecases.implementation

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.domain.models.errors.FailureMapper
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class PeopleListSwUseCaseImpl @Inject constructor(
    private val peopleListSwRepository: PeopleListSwRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) :
    PeopleListSwUseCase {

    override suspend fun getPeopleListSwResource(): Resource<PeopleSWDomain> =
        withContext(coroutineDispatcher) {
            try {
                Resource.Success(peopleListSwRepository.getPeopleListSwResource())
            }catch (exception:Exception){
                Resource.Error(FailureMapper.map(exception))
            }
        }

}