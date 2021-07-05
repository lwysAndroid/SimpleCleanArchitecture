package com.example.luistovar.archapp.framework.presentation.listdata

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.luistovar.archapp.LiveDataTestUtil
import com.example.luistovar.archapp.MainCoroutineRule
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.usecases.implementation.FakePeopleListSwUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule

import org.junit.Test

@ExperimentalCoroutinesApi
class ListViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Subject under test
    private lateinit var listViewModel: ListViewModel

    // Use a fake use case to be injected into the viewmodel
    private val peopleListSwUseCase = FakePeopleListSwUseCase()

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setupListViewModel() {
        listViewModel = ListViewModel(peopleListSwUseCase)
    }


    @Test
    fun `get People List Sw Resource`() {
        val peopleListSw = PeopleListSw()
        peopleListSwUseCase.peopleListSw = peopleListSw
        listViewModel.getPeopleListSwResource()
        assertThat(LiveDataTestUtil.getValue(listViewModel.peopleListSwLiveData)).isEqualTo(
            peopleListSw
        )

    }

    @Test
    fun `get People List Sw Resource 2`() = mainCoroutineRule.runBlockingTest {
        val peopleListSw = PeopleListSw()
        peopleListSwUseCase.peopleListSw = peopleListSw
        listViewModel.getPeopleListSwResource()
        assertThat(LiveDataTestUtil.getValue(listViewModel.peopleListSwLiveData)).isEqualTo(
            peopleListSw
        )

    }
}