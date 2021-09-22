package com.example.luistovar.archapp.domain.usecases

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.domain.models.errors.FailureMapper
import java.lang.Exception
import javax.inject.Inject

open class PeopleListSwUseCase @Inject constructor(
    private val peopleListSwRepository: PeopleListSwRepository
) {

    open suspend fun getPeopleListSwResource(): Resource<PeopleSWDomain> =
        try {
            Resource.Success(peopleListSwRepository.getPeopleListSwResource())
        } catch (exception: Exception) {
            Resource.Error(FailureMapper.map(exception))
        }

}