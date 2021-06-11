package com.example.luistovar.archapp.presentation.listdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luistovar.archapp.domain.models.PeopleListSw
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.domain.usecases.PeopleListSwUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(private val peopleListSwUseCase: PeopleListSwUseCase) :
    ViewModel() {

    private val _peopleListSwLiveData = MutableLiveData<PeopleListSw?>()
    val peopleListSwLiveData: LiveData<PeopleListSw?>
        get() = _peopleListSwLiveData

    private val _showError = MutableLiveData<String?>()
    val showError: LiveData<String?>
        get() = _showError

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    fun getPeopleListSw() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _isLoading.postValue(true)
                val people = peopleListSwUseCase.getPeopleListSW()
                _peopleListSwLiveData.postValue(people)
                _isLoading.postValue(false)
            }
        }
    }

    fun getPeopleListSwResource() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _isLoading.postValue(true)

                val peopleResource = peopleListSwUseCase.getPeopleListSwResource()
                if (peopleResource is Resource.Success) {
                    _peopleListSwLiveData.postValue(peopleResource.data)
                } else {
                    _showError.postValue(peopleResource.message)
                }
                _isLoading.postValue(false)
            }
        }
    }

}