package com.example.luistovar.archapp.domain.usecases.implementation

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PeopleListSwUseCaseImplTest {

    @Mock
    private lateinit var peopleListSwRepository: PeopleListSwRepository

    private lateinit var peopleListSwUseCaseImpl: PeopleListSwUseCaseImpl

    @Before
    fun setUp() {
        peopleListSwUseCaseImpl = PeopleListSwUseCaseImpl(peopleListSwRepository)
//        `when`(peopleListSwRepository.getPeopleListSW())
    }

    @Test
    fun getPeopleListSW() {
    }
}