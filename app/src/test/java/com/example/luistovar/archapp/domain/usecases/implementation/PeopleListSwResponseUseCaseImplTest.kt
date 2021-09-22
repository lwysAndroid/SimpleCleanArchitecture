package com.example.luistovar.archapp.domain.usecases.implementation

import com.example.luistovar.archapp.data.repositories.PeopleListSwRepository
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PeopleListSwResponseUseCaseImplTest {

    @Mock
    private lateinit var peopleListSwRepository: PeopleListSwRepository

    private lateinit var peopleListSwUseCase: PeopleListSwUseCase

    private lateinit var coroutineDispatcher: CoroutineDispatcher

    @Before
    fun setUp() {
        coroutineDispatcher = TestCoroutineDispatcher()
        peopleListSwUseCase =
            PeopleListSwUseCase(peopleListSwRepository)
    }

    @Test
    fun getPeopleListSW() {
    }
}