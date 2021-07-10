package com.example.luistovar.archapp.framework.presentation.listdata

import com.example.luistovar.archapp.framework.network.webservices.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.framework.BaseTest
import com.example.luistovar.archapp.testutils.getValueTest
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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
        val peopleListSw = PeopleListSw()
        Mockito.`when`(peopleListSwUseCase.getPeopleListSwResource())
            .then { Resource.Success(peopleListSw) }
        listViewModel.getPeopleListSwResource()
        val resource = listViewModel.peopleListSwLiveData.getValueTest()
        assertThat(resource).isEqualTo(
            peopleListSw
        )
    }

    @Test
    fun `on get People List Sw Resource return error`() = runBlockingTest {
        Mockito.`when`(peopleListSwUseCase.getPeopleListSwResource())
            .then { Resource.Error<PeopleListSw>("No Data") }
        listViewModel.getPeopleListSwResource()
        val resource = listViewModel.showError.getValueTest()
        assertThat(resource).isEqualTo("No Data")
    }
}