package com.example.luistovar.archapp.usecases.implementation

import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.usecases.PeopleListSwUseCase

class FakePeopleListSwUseCase : PeopleListSwUseCase {

    var peopleListSwResource: Resource<PeopleListSw?>? = null
    var peopleListSw: PeopleListSw? = null

    override suspend fun getPeopleListSwResource(): Resource<PeopleListSw?> {
        return if (peopleListSwResource != null) {
            peopleListSwResource!!
        } else {
            if (peopleListSw != null) {
                Resource.Success(peopleListSw)
            } else {
                Resource.Error("No Data")
            }
        }
    }
}