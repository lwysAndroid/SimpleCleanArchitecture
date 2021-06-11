package com.example.luistovar.archapp.domain.usecases

import com.example.luistovar.archapp.domain.models.PeopleListSw

interface PeopleListSwUseCase {

    suspend fun getPeopleListSW(): PeopleListSw?

}