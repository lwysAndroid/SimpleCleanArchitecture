package com.example.luistovar.archapp.data.repositories

import com.example.luistovar.archapp.domain.models.PeopleListSw

interface PeopleListSwRepository {

    suspend fun getPeopleListSW(): PeopleListSw?
}