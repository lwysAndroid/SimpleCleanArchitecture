package com.example.luistovar.archapp.presentation.listdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import com.example.luistovar.archapp.presentation.commons.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val peopleListSwUseCase: PeopleListSwUseCase,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) :
    ViewModel() {

    private val _peopleListSwLiveData = MutableLiveData<Resource<PeopleSWDomain>>()
    val peopleListSwLiveData: LiveData<Resource<PeopleSWDomain>> = _peopleListSwLiveData

    fun getPeopleListSwResource() {
        viewModelScope.launch(coroutineDispatcherProvider.io) {
            _peopleListSwLiveData.postValue(Resource.Loading())
            val peopleResource = peopleListSwUseCase.getPeopleListSwResource()
            if (peopleResource is Resource.Success) {
                _peopleListSwLiveData.postValue(Resource.Success(peopleResource.data!!))
            } else {
                _peopleListSwLiveData.postValue(Resource.Error(peopleResource.failure!!))
            }
        }
    }

}