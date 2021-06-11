package com.example.luistovar.archapp.data.datasources

import com.example.luistovar.archapp.domain.models.PeopleListSw

interface PeopleListSwDataSource {

    suspend fun getPeopleListSW(): PeopleListSw?
}