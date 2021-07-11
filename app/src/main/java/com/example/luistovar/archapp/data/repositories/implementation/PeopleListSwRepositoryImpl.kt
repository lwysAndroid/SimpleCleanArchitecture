package com.example.luistovar.archapp.data.repositories.implementation

import com.example.luistovar.archapp.data.datasources.remote.PeopleListSwRemoteDataSource
import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.models.PeopleSWDataDomain
import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.domain.models.errors.exceptions.InvalidDataException
import com.example.luistovar.archapp.domain.models.errors.exceptions.NullOrEmptyListPeopleSwException
import com.example.luistovar.archapp.domain.models.errors.exceptions.NullResponseException
import javax.inject.Inject

class PeopleListSwRepositoryImpl @Inject constructor(
    private val remoteRemoteDataSource: PeopleListSwRemoteDataSource
) :
    PeopleListSwRepository {


    override suspend fun getPeopleListSwResource(): PeopleSWDomain {

        val peopleResponse = remoteRemoteDataSource.getPeopleListSwResource()
            ?: throw NullResponseException()

        val peopleList = peopleResponse.peopleData
            ?: throw NullOrEmptyListPeopleSwException()
        val peopleSWDataDomain: List<PeopleSWDataDomain>
        if (peopleList.isEmpty()) {
            throw NullOrEmptyListPeopleSwException()
        } else {
            peopleSWDataDomain = peopleList.map { peopleData ->
                if (peopleData.name != null && peopleData.gender != null) {
                    PeopleSWDataDomain(peopleData.name!!, peopleData.gender!!)
                } else {
                    throw InvalidDataException()
                }
            }
        }

        return PeopleSWDomain(peopleSWDataDomain)
    }

}