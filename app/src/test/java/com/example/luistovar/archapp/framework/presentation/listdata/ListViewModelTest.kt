package com.example.luistovar.archapp.framework.presentation.listdata

import com.example.luistovar.archapp.domain.models.errors.Failure
import com.example.luistovar.archapp.domain.models.PeopleSWDataDomain
import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSwResponse
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.framework.BaseTest
import com.example.luistovar.archapp.testutils.getValueTest
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ListViewModelTest : BaseTest() {

    // Subject under test
    private lateinit var listViewModel: ListViewModel

    // Use a fake use case to be injected into the viewmodel
    private lateinit var peopleListSwUseCase: PeopleListSwUseCase

    @Before
    fun setupListViewModel() {
        peopleListSwUseCase = mock(PeopleListSwUseCase::class.java)
        listViewModel = ListViewModel(peopleListSwUseCase)
    }

    @Test
    fun `on get People List Sw Resource return success`() = runBlockingTest {
        val peopleSWDomain = PeopleSWDomain(arrayListOf(PeopleSWDataDomain("Juan","male")))
        Mockito.`when`(peopleListSwUseCase.getPeopleListSwResource())
            .then { Resource.Success(peopleSWDomain) }
        listViewModel.getPeopleListSwResource()
        val resource = listViewModel.peopleListSwLiveData.getValueTest()
        if (resource is Resource.Success) {
            assertThat(resource.data).isEqualTo(peopleSWDomain)
        } else {
            Assert.fail("Resource should be success: $resource")
        }
    }

    @Test
    fun `on get People List Sw Resource return error`() = runBlockingTest {
        val failure = Failure.GeneralFailure("No Data")
        Mockito.`when`(peopleListSwUseCase.getPeopleListSwResource())
            .then { Resource.Error<PeopleListSwResponse>(failure) }
        listViewModel.getPeopleListSwResource()
        val resource = listViewModel.peopleListSwLiveData.getValueTest()
        if (resource is Resource.Error) {
            assertThat(resource.failure).isEqualTo(failure)
        } else {
            Assert.fail("Resource should be error: $resource")
        }
    }

}